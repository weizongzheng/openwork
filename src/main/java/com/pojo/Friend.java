package com.pojo;
import java.util.Date;
public class Friend {
    private String M_username;
    private String username;
    private Date create_time;
    private String nickname;
    public Friend(String m_username, String username, Date create_time, String nickname) {
        M_username = m_username;
        this.username = username;
        this.create_time = create_time;
        this.nickname = nickname;
    }
    @Override
    public String toString() {
        return "Friend{" +
                "M_username='" + M_username + '\'' +
                ", username='" + username + '\'' +
                ", create_time=" + create_time +
                ", nickname='" + nickname + '\'' +
                '}';
    }
    public String getNickname() {
        return nickname;
    }
    public void setNickname(String nickname) {
        this.nickname = nickname;
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
    public Date getCreate_time() {
        return create_time;
    }
    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }
    public Friend() {
    }
}
