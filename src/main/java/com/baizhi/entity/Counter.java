package com.baizhi.entity;

import java.util.Date;

public class Counter {
    private String id;
    private String title;
    private Integer count;
    private Date recordDate;
    private User userId;
    private Course courseId;

    public Counter() {
    }

    public Counter(String id, String title, Integer count, Date recordDate, User userId, Course courseId) {
        this.id = id;
        this.title = title;
        this.count = count;
        this.recordDate = recordDate;
        this.userId = userId;
        this.courseId = courseId;
    }

    @Override
    public String toString() {
        return "Counter{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", count=" + count +
                ", recordDate=" + recordDate +
                ", userId=" + userId +
                ", courseId=" + courseId +
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

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Date getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(Date recordDate) {
        this.recordDate = recordDate;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public Course getCourseId() {
        return courseId;
    }

    public void setCourseId(Course courseId) {
        this.courseId = courseId;
    }
}
