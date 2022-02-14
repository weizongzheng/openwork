package com.pojo;
import java.util.Date;
public class Talking {
    private String M_username;
    private String username;
    private int received;
    private String content;
    private Date send_time;
    @Override
    public String toString() {
        return "Talking{" +
                "M_username='" + M_username + '\'' +
                ", username='" + username + '\'' +
                ", received=" + received +
                ", content='" + content + '\'' +
                ", send_time=" + send_time +
                '}';
    }
    public String getM_username() {
        return M_username;
    }
    public void setM_username(String m_username) {
        M_username = m_username;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public int getReceived() {
        return received;
    }
    public void setReceived(int received) {
        this.received = received;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public Date getSend_time() {
        return send_time;
    }
    public void setSend_time(Date send_time) {
        this.send_time = send_time;
    }
    public Talking() {
    }
    public Talking(String m_username, String username, int received, String content, Date send_time) {
        M_username = m_username;
        this.username = username;
        this.received = received;
        this.content = content;
        this.send_time = send_time;
    }
}
