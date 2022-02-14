package com.pojo;
import java.util.Date;
public class Course {
    private String course_id;
    private Date create_time;
    private String create_user;
    private String title;
    private int into_number;
    private int filed;
    private String description;
    public Course(String course_id, Date create_time, String create_user, String title, int into_number, int filed, String description) {
        this.course_id = course_id;
        this.create_time = create_time;
        this.create_user = create_user;
        this.title = title;
        this.into_number = into_number;
        this.filed = filed;
        this.description = description;
    }
    public String getCourse_id() {
        return course_id;
    }
    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }
    public Date getCreate_time() {
        return create_time;
    }
    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }
    public String getCreate_user() {
        return create_user;
    }
    public void setCreate_user(String create_user) {
        this.create_user = create_user;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public int getInto_number() {
        return into_number;
    }

    public void setInto_number(int into_number) {
        this.into_number = into_number;
    }
    public int getFiled() {
        return filed;
    }
    public void setFiled(int filed) {
        this.filed = filed;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    @Override
    public String toString() {
        return "Course{" +
                "course_id='" + course_id + '\'' +
                ", create_time=" + create_time +
                ", create_user='" + create_user + '\'' +
                ", title='" + title + '\'' +
                ", into_number=" + into_number +
                ", filed=" + filed +
                ", description='" + description + '\'' +
                '}';
    }
    public Course() {
    }
}
