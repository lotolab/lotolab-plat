package com.lotolab.plat.obs.service;

import cn.hutool.core.util.IdUtil;
import com.lotolab.plat.obs.config.UploadFileType;
import com.lotolab.plat.obs.vo.UploadResultVo;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public interface ObjectStorageService {

    UploadResultVo upload(MultipartFile file,String path);

    static ByteArrayOutputStream copyInputStrea(InputStream inputStream) throws IOException {

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        // 定义一个缓存数组，临时存放读取的数组
        // 经过测试，4*1024是一个非常不错的数字，过大过小都会比较影响性能
        byte[] buffer = new byte[4096];
        int len;
        while ((len = inputStream.read(buffer)) > -1) {
            baos.write(buffer,0,len);
        }
        baos.flush();
        return baos;
    }

    /**
     *
     * @param cdn like https://cdn.lotolab.com or https://cdn.lotolab.com/
     * @param path avatar/xxx.png
     * @return string https://cdn.lotolab.com/avatar/xxx.png or /avatar/xxx.png
     */
    static String buildCDNPath(String cdn, String path) {
        if(path.startsWith("/")){
            path = path.substring(1);
        }
        if(cdn == null || cdn.isEmpty()) return "/"+path;
        if(cdn.endsWith("/"))return cdn+path;
        return cdn+"/"+path;
    }

    static String buildSubPath(String originalFilename,String project) {
        String extension = originalFilename.substring(originalFilename.lastIndexOf("."));
        String filename = originalFilename.substring(0,originalFilename.lastIndexOf("."));
        String uuid = IdUtil.fastSimpleUUID();
        StringBuilder sb = new StringBuilder();
        if(project.endsWith("/")){
            sb.append(project);
        }else {
            sb.append(project).append("/");
        }

        sb.append(filename).append("_").append(uuid);
        sb.append(extension);
        return sb.toString();
    }
}
