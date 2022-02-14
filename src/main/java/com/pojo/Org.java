package com.pojo;
import java.util.Date;
public class Org {
    private String org_id;
    private String create_username;
    private Date create_time;
    private String org_name;
    private String content;
    private int into_number;
    public String getOrg_id() {
        return org_id;
    }
    @Override
    public String toString() {
        return "Org{" +
                "org_id='" + org_id + '\'' +
                ", create_username='" + create_username + '\'' +
                ", create_time=" + create_time +
                ", org_name='" + org_name + '\'' +
                ", content='" + content + '\'' +
                ", into_number=" + into_number +
                '}';
    }
    public void setOrg_id(String org_id) {
        this.org_id = org_id;
    }
    public String getCreate_username() {
        return create_username;
    }
    public void setCreate_username(String create_username) {
        this.create_username = create_username;
    }
    public Date getCreate_time() {
        return create_time;
    }
    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }
    public String getOrg_name() {
        return org_name;
    }
    public void setOrg_name(String org_name) {
        this.org_name = org_name;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public int getInto_number() {
        return into_number;
    }
    public void setInto_number(int into_number) {
        this.into_number = into_number;
    }
    public Org(String org_id, String create_username, Date create_time, String org_name, String content, int into_number) {
        this.org_id = org_id;
        this.create_username = create_username;
        this.create_time = create_time;
        this.org_name = org_name;
        this.content = content;
        this.into_number = into_number;
    }
    public Org() {
    }
}
