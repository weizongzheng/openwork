package com.pojo;
public class IntoWork {
    private String course_id;
    private int work_id;
    private String username;
    private int submited;
    private String file;
    private String content;
    public String getContent() {
        return content;
    }
    @Override
    public String toString() {
        return "IntoWork{" +
                "course_id='" + course_id + '\'' +
                ", work_id=" + work_id +
                ", username='" + username + '\'' +
                ", submited=" + submited +
                ", file='" + file + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
    public void setContent(String content) {
        this.content = content;
    }
    public IntoWork(String course_id, int work_id, String username, int submited, String file, String content) {
        this.course_id = course_id;
        this.work_id = work_id;
        this.username = username;
        this.submited = submited;
        this.file = file;
        this.content = content;
    }
    public String getCourse_id() {
        return course_id;
    }
    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }
    public int getWork_id() {
        return work_id;
    }
    public void setWork_id(int work_id) {
        this.work_id = work_id;
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
    public String getFile() {
        return file;
    }
    public void setFile(String file) {
        this.file = file;
    }
    public IntoWork() {
    }
}
