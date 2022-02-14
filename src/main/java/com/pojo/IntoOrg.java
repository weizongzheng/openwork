package com.pojo;
public class IntoOrg {
    private String org_id;
    private String username;
    private int deleted ;
    public IntoOrg(String org_id, String username, int deleted) {
        this.org_id = org_id;
        this.username = username;
        this.deleted = deleted;
    }
    @Override
    public String toString() {
        return "IntoOrg{" +
                "org_id='" + org_id + '\'' +
                ", username='" + username + '\'' +
                ", deleted=" + deleted +
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
    public int getDeleted() {
        return deleted;
    }
    public void setDeleted(int deleted) {
        this.deleted = deleted;
    }
    public IntoOrg() {
    }
}
