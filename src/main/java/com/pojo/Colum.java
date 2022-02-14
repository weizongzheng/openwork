package com.pojo;
public class Colum {
    private  int colum_id;
    private  String username;
    private String colum_name;
    private int pro;
    private int num;
    public Colum(int colum_id, String username, String colum_name, int pro, int num) {
        this.colum_id = colum_id;
        this.username = username;
        this.colum_name = colum_name;
        this.pro = pro;
        this.num = num;
    }
    @Override
    public String toString() {
        return "Colum{" +
                "colum_id=" + colum_id +
                ", username='" + username + '\'' +
                ", colum_name='" + colum_name + '\'' +
                ", pro=" + pro +
                ", num=" + num +
                '}';
    }
    public int getNum() {
        return num;
    }
    public void setNum(int num) {
        this.num = num;
    }
    public int getColum_id() {
        return colum_id;
    }
    public void setColum_id(int colum_id) {
        this.colum_id = colum_id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getColum_name() {
        return colum_name;
    }
    public void setColum_name(String colum_name) {
        this.colum_name = colum_name;
    }
    public int getPro() {
        return pro;
    }
    public void setPro(int pro) {
        this.pro = pro;
    }
    public Colum() {
    }
}
