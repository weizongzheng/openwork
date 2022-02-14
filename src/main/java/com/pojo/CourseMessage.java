package com.pojo;
import java.util.Date;
public class CourseMessage {
    private String course_id;
    private String username;
    private Date create_time;
    private int readed;
    private String content;
    public CourseMessage(String course_id, String username, Date create_time, int readed, String content) {
        this.course_id = course_id;
        this.username = username;
        this.create_time = create_time;
        this.readed = readed;
        this.content = content;
    }
    @Override
    public String toString() {
        return "CourseMessage{" +
                "course_id='" + course_id + '\'' +
                ", username='" + username + '\'' +
                ", create_time=" + create_time +
                ", readed=" + readed +
                ", content='" + content + '\'' +
                '}';
    }
    public String getCourse_id() {
        return course_id;
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
    public Date getCreate_time() {
        return create_time;
    }
    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }
    public int getReaded() {
        return readed;
    }
    public void setReaded(int readed) {
        this.readed = readed;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public CourseMessage() {
    }
}
