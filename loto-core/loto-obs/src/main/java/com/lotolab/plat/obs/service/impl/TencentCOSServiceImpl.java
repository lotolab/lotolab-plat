package com.lotolab.plat.obs.service.impl;

import com.lotolab.plat.obs.config.ObsConfig;
import com.lotolab.plat.obs.config.ObsConstants;
import com.lotolab.plat.obs.config.UploadFileType;
import com.lotolab.plat.obs.config.properties.TencentCosProperties;
import com.lotolab.plat.obs.service.ObjectStorageService;
import com.lotolab.plat.obs.vo.UploadResultVo;
import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.model.ObjectMetadata;
import com.qcloud.cos.model.PutObjectResult;
import com.qcloud.cos.region.Region;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;


@Slf4j
@ConditionalOnProperty(name="loto.obs.type",havingValue = "tencent")
@Service
public class TencentCOSServiceImpl implements ObjectStorageService {

    private final TencentCosProperties properties;
    private final COSClient cosClient;
    private final ObsConfig obsConfig;


    public TencentCOSServiceImpl(TencentCosProperties properties,ObsConfig obsConfig) {
        this.properties = properties;
        this.obsConfig = obsConfig;
        COSCredentials credentials = new BasicCOSCredentials(properties.getSecretId(),properties.getSecretKey());
        ClientConfig clientConfig = new ClientConfig(new Region(properties.getRegion()));
        cosClient = new COSClient(credentials,clientConfig);
    }

    /**
     *
     * @param file file
     * @param path sub folder
     * @return UploadResultVo
     */
    @Override
    public UploadResultVo upload(MultipartFile file, String path) {
        if(file == null || file.isEmpty() || file.getSize() <= 0) {
            return UploadResultVo.fail("File is null or empty");
        }

        long imageSize = file.getSize();
        if(imageSize > obsConfig.maxSize()*1024*1024) {
            return UploadResultVo.fail("File too large,max size is"+obsConfig.maxSize()+" MB.");
        }

        try{

            String key = ObjectStorageService.buildSubPath(Objects.requireNonNull(file.getOriginalFilename()), path);
            String etag = uploadToCos(file.getInputStream(), key);
            return UploadResultVo.success(ObjectStorageService.buildCDNPath(properties.getCdn(),key)).message(etag);
        }catch (IOException e){
            log.error("Upload file {} error: {}",file.getOriginalFilename(),e.getMessage(),e.getCause());
            return UploadResultVo.fail("上传失败");
        }
    }

    /**
     *
     * @param in
     * @param key
     * @return url
     */
    private String uploadToCos(InputStream in,String key) throws IOException {
        String etag = "";
        try{
            ObjectMetadata meta = new ObjectMetadata();
            // 设置输入流长度为500
            meta.setContentLength(in.available());
            // ContentType
            String contentType = UploadFileType.contentType(key.substring(key.lastIndexOf(".")+1)).getContentType();
            meta.setContentType(contentType);

            // 上传
            PutObjectResult result = cosClient.putObject(properties.getBucket(),key,in,meta);
            etag = result.getETag();
        }catch (IOException e){
            log.error("Upload file {} error: {}",key,e.getMessage(),e.getCause());
            throw e;
        }finally {
            try {
                if(in != null){
                    in.close();
                }
                // cosClient.shutdown();
            }catch (IOException ioe){
                ioe.printStackTrace();
            }
        }

        return etag;
    }
}
