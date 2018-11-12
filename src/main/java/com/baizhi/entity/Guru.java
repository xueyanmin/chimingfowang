package com.baizhi.entity;

public class Guru {
    private String id;
    private String name;
    private String headPicPath;
    private String sex;
    private Integer status;

    public Guru() {
    }

    public Guru(String id, String name, String headPicPath, String sex, Integer status) {
        this.id = id;
        this.name = name;
        this.headPicPath = headPicPath;
        this.sex = sex;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Guru{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", headPicPath='" + headPicPath + '\'' +
                ", sex='" + sex + '\'' +
                ", status=" + status +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHeadPicPath() {
        return headPicPath;
    }

    public void setHeadPicPath(String headPicPath) {
        this.headPicPath = headPicPath;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
