package com.pojo;
import java.util.Date;
public class User {
    private String name;
    private String username;
    private String number;
    private String school;
    private Date create_time;
    private String sex;
    private String classes;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getNumber() {
        return number;
    }
    public void setNumber(String number) {
        this.number = number;
    }
    public String getSchool() {
        return school;
    }
    public void setSchool(String school) {
        this.school = school;
    }
    public Date getCreate_time() {
        return create_time;
    }
    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }
    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public String getClasses() {
        return classes;
    }
    public void setClasses(String classes) {
        this.classes = classes;
    }
    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", number='" + number + '\'' +
                ", school='" + school + '\'' +
                ", create_time=" + create_time +
                ", sex='" + sex + '\'' +
                ", classes='" + classes + '\'' +
                '}';
    }
    public User(String name, String username, String number, String school, Date create_time, String sex, String classes) {
        this.name = name;
        this.username = username;
        this.number = number;
        this.school = school;
        this.create_time = create_time;
        this.sex = sex;
        this.classes = classes;
    }
    public User() {
    }
}
