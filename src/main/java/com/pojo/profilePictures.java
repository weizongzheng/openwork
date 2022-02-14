package com.pojo;
public class profilePictures {
    private String username;
    private String file;
    @Override
    public String toString() {
        return "profilePictures{" +
                "username='" + username + '\'' +
                ", file='" + file + '\'' +
                '}';
    }
    public profilePictures(String username, String file) {
        this.username = username;
        this.file = file;
    }
    public profilePictures() {
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getFile() {
        return file;
    }
    public void setFile(String file) {
        this.file = file;
    }
}
