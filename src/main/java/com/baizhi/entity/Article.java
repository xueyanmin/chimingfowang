package com.baizhi.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

public class Article {
    private String id;
    private String title;
    private String imgPath;
    private String content;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @JSONField(format = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date publishDate;
    private String link;
    private String illuStration;
    private Guru guruId;

    public Article() {
    }

    public Article(String id, String title, String imgPath, String content, Date publishDate, String link, String illuStration, Guru guruId) {
        this.id = id;
        this.title = title;
        this.imgPath = imgPath;
        this.content = content;
        this.publishDate = publishDate;
        this.link = link;
        this.illuStration = illuStration;
        this.guruId = guruId;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", imgPath='" + imgPath + '\'' +
                ", content='" + content + '\'' +
                ", publishDate=" + publishDate +
                ", link='" + link + '\'' +
                ", illuStration='" + illuStration + '\'' +
                ", guruId=" + guruId +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getIlluStration() {
        return illuStration;
    }

    public void setIlluStration(String illuStration) {
        this.illuStration = illuStration;
    }

    public Guru getGuruId() {
        return guruId;
    }

    public void setGuruId(Guru guruId) {
        this.guruId = guruId;
    }
}
