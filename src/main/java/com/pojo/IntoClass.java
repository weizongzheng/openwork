package com.pojo;
public class IntoClass {
    private String course_id;
    private String username;
    private int submited;
    private int filed;
    private int deleted;
    public String getCourse_id() {
        return course_id;
    }
    @Override
    public String toString() {
        return "IntoClass{" +
                "course_id='" + course_id + '\'' +
                ", username='" + username + '\'' +
                ", submited=" + submited +
                ", filed=" + filed +
                ", deleted=" + deleted +
                '}';
    }
    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public int getSubmited() {
        return submited;
    }
    public void setSubmited(int submited) {
        this.submited = submited;
    }
    public int getFiled() {
        return filed;
    }
    public void setFiled(int filed) {
        this.filed = filed;
    }
    public int getDeleted() {
        return deleted;
    }
    public void setDeleted(int deleted) {
        this.deleted = deleted;
    }
    public IntoClass(String course_id, String username, int submited, int filed, int deleted) {
        this.course_id = course_id;
        this.username = username;
        this.submited = submited;
        this.filed = filed;
        this.deleted = deleted;
    }
    public IntoClass() {
    }
}
