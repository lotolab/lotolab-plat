package com.lotolab.plat.obs.vo;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true,fluent = true)
public class UploadResultVo {

    private final boolean isSuccess;
    private String message;
    private String url;
    private String filepath;

    public UploadResultVo(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public UploadResultVo(String url, String filepath, boolean isSuccess) {
        this.url = url;
        this.filepath = filepath;
        this.isSuccess = isSuccess;
    }

    public static UploadResultVo success(String url, String filepath) {
        return new UploadResultVo(url,filepath,true);
    }

    public static UploadResultVo success(String url) {
        return new UploadResultVo(true).url(url);
    }

    public static UploadResultVo fail(String message){
        return new UploadResultVo(false).message(message);
    }
}
