package com.pojo;
import java.util.Date;
public class RequestUser {
    private String M_username;
    private String username;
    private int agree;
    private int looked;
    private String content;
    private Date send_time;
    public String getM_username() {
        return M_username;
    }
    public RequestUser(String m_username, String username, int agree, int looked, String content, Date send_time) {
        M_username = m_username;
        this.username = username;
        this.agree = agree;
        this.looked = looked;
        this.content = content;
        this.send_time = send_time;
    }
    @Override
    public String toString() {
        return "RequestUser{" +
                "M_username='" + M_username + '\'' +
                ", username='" + username + '\'' +
                ", agree=" + agree +
                ", looked=" + looked +
                ", content='" + content + '\'' +
                ", send_time=" + send_time +
                '}';
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
    public int getAgree() {
        return agree;
    }
    public void setAgree(int agree) {
        this.agree = agree;
    }
    public int getLooked() {
        return looked;
    }
    public void setLooked(int looked) {
        this.looked = looked;
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
    public RequestUser() {
    }
}
