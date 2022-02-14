package com.pojo;
import java.util.Date;
public class FriendMessage {
    private String m_username;
    private String username;
    private Date create_time;
    private int readed;
    private String content;
    private int m_colum_id;
    private int colum_id;
    private String m_nickname;
    private String nickname;
    private int isok;
    private Date sub_time;
    public Date getSub_time() {
        return sub_time;
    }
    public void setSub_time(Date sub_time) {
        this.sub_time = sub_time;
    }
    public FriendMessage(String m_username, String username, Date create_time, int readed, String content, int m_colum_id, int colum_id, String m_nickname, String nickname, int isok, Date sub_time) {
        this.m_username = m_username;
        this.username = username;
        this.create_time = create_time;
        this.readed = readed;
        this.content = content;
        this.m_colum_id = m_colum_id;
        this.colum_id = colum_id;
        this.m_nickname = m_nickname;
        this.nickname = nickname;
        this.isok = isok;
        this.sub_time = sub_time;
    }
    @Override
    public String toString() {
        return "FriendMessage{" +
                "m_username='" + m_username + '\'' +
                ", username='" + username + '\'' +
                ", create_time=" + create_time +
                ", readed=" + readed +
                ", content='" + content + '\'' +
                ", m_colum_id=" + m_colum_id +
                ", colum_id=" + colum_id +
                ", m_nickname='" + m_nickname + '\'' +
                ", nickname='" + nickname + '\'' +
                ", isok=" + isok +
                ", sub_time=" + sub_time +
                '}';
    }
    public String getM_username() {
        return m_username;
    }
    public int getIsok() {
        return isok;
    }
    public void setIsok(int isok) {
        this.isok = isok;
    }
    public String getM_nickname() {
        return m_nickname;
    }
    public void setM_nickname(String m_nickname) {
        this.m_nickname = m_nickname;
    }
    public String getNickname() {
        return nickname;
    }
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    public void setM_username(String m_username) {
        this.m_username = m_username;
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
    public int getM_colum_id() {
        return m_colum_id;
    }
    public void setM_colum_id(int m_colum_id) {
        this.m_colum_id = m_colum_id;
    }
    public int getColum_id() {
        return colum_id;
    }
    public void setColum_id(int colum_id) {
        this.colum_id = colum_id;
    }
    public FriendMessage() {
    }
}
