package com.lotolab.plat.obs.config;

import java.util.Arrays;

public enum UploadFileType {
    bmp("image/bmp"),
    gif("image/gif"),
    jpeg("image/jpeg"),
    jpg("image/jpeg"),
    png("image/png"),
    html("text/html"),
    text("text/plain"),
    vsd("application/vnd.visio"),
    ppt("application/vnd.ms-powerpoint"),
    pptx("application/vnd.ms-powerpoint"),
    doc("application/msword"),
    docx("application/msword"),
    xls("application/vnd.ms-excel"),
    xlsx("application/vnd.ms-excel"),
    pdf("application/octet-stream"), // 防止自动下载，直接预览
    xml("text/xml"),
    mp4("application/octet-stream"),

    mp3("audio/mp3"),
    wav("audio/wav"),
   ;


    private String contentType;

    public String getContentType() {
        return contentType;
    }

    UploadFileType(String contentType) {
        this.contentType = contentType;
    }

    public static boolean equalsKey(UploadFileType type,String key) {
        return key.equalsIgnoreCase(type.name());
    }

    public static UploadFileType contentType(String key) {
        UploadFileType[] types = UploadFileType.values();

        return Arrays.stream(types).filter(t->t.name().equalsIgnoreCase(key)).findFirst().orElse(UploadFileType.jpeg);
    }
}
