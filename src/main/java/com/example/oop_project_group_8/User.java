package com.example.oop_project_group_8;

public abstract class User {
    protected String userId;
    protected String email;
    protected String password;

    public User(String userId, String email, String password) {
        this.userId = userId;
        this.email = email;
        this.password = password;
    }

    public String getUserId() {
        return userId;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public abstract String getRole();

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}