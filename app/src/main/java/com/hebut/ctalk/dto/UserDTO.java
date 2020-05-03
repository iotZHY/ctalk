package com.hebut.ctalk.dto;

public class UserDTO {
    private String uid;
    private String username;
    private String gender;
    private String password;
    private String level;//等级
    private String profilePicture;//头像path

    public UserDTO() {

    }

    public UserDTO(String id, String username, String gender, String password, String level, String profilePicture) {
        this.uid = id;
        this.username = username;
        this.gender = gender;
        this.password = password;
        this.level = level;
        this.profilePicture = profilePicture;
    }

    public String getId() { return uid; }

    public void setId(String uid) { this.uid = uid; }

    public String getUsername() { return username; }

    public void setName(String username) { this.username = username; }

    public String getGender() { return gender; }

    public void setGender(String gender) { this.gender = gender; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public String getLevel() { return level; }

    public void setLevel(String level) { this.level = level; }

    public String getProfilePicture() { return profilePicture; }

    public void setProfilePicture(String profilePicture) { this.profilePicture = profilePicture; }
}
