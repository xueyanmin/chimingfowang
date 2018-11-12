package com.baizhi.entity;

public class FileParm {
    private  String url;
    private String oldFileName;

    public FileParm() {
    }

    public FileParm(String url, String oldFileName) {
        this.url = url;
        this.oldFileName = oldFileName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getOldFileName() {
        return oldFileName;
    }

    public void setOldFileName(String oldFileName) {
        this.oldFileName = oldFileName;
    }

    @Override
    public String toString() {
        return "FileParm{" +
                "url='" + url + '\'' +
                ", oldFileName='" + oldFileName + '\'' +
                '}';
    }
}
