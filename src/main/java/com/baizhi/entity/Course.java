package com.baizhi.entity;

import java.util.Date;

public class Course {
    private String id;
    private String title;
    private String marking;
    private Date createDate;
    private User userId;

    public Course() {
    }

    public Course(String id, String title, String marking, Date createDate, User userId) {
        this.id = id;
        this.title = title;
        this.marking = marking;
        this.createDate = createDate;
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", marking='" + marking + '\'' +
                ", createDate=" + createDate +
                ", userId=" + userId +
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

    public String getMarking() {
        return marking;
    }

    public void setMarking(String marking) {
        this.marking = marking;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }
}
