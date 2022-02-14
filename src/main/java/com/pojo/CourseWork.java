package com.pojo;
public class CourseWork {
    private String course_id;
    private int work_id;
    private String work_name;
    private String work_content;
    private String file;
    public CourseWork(String course_id, int work_id, String work_name, String work_content, String file) {
        this.course_id = course_id;
        this.work_id = work_id;
        this.work_name = work_name;
        this.work_content = work_content;
        this.file = file;
    }
    public String getFile() {
        return file;
    }
    @Override
    public String toString() {
        return "CourseWork{" +
                "course_id='" + course_id + '\'' +
                ", work_id=" + work_id +
                ", work_name='" + work_name + '\'' +
                ", work_content='" + work_content + '\'' +
                ", file='" + file + '\'' +
                '}';
    }
    public void setFile(String file) {
        this.file = file;
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
    public String getWork_name() {
        return work_name;
    }
    public void setWork_name(String work_name) {
        this.work_name = work_name;
    }
    public String getWork_content() {
        return work_content;
    }
    public void setWork_content(String work_content) {
        this.work_content = work_content;
    }
    public CourseWork() {
    }
}
