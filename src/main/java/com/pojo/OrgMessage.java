package com.pojo;
import java.util.Date;
public class OrgMessage {
    private String org_id;
    private String username;
    private Date create_time;
    private int readed;
    private String content;
    @Override
    public String toString() {
        return "OrgMessage{" +
                "org_id='" + org_id + '\'' +
                ", username='" + username + '\'' +
                ", create_time=" + create_time +
                ", readed=" + readed +
                ", content='" + content + '\'' +
                '}';
    }
    public String getOrg_id() {
        return org_id;
    }
    public void setOrg_id(String org_id) {
        this.org_id = org_id;
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
    public OrgMessage(String org_id, String username, Date create_time, int readed, String content) {
        this.org_id = org_id;
        this.username = username;
        this.create_time = create_time;
        this.readed = readed;
        this.content = content;
    }
    public OrgMessage() {
    }
}
