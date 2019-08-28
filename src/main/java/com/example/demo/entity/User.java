package com.example.demo.entity;

public class User {
    private String usercode;

    private String username;

    private String department;

    public String getUsercode() {
        return usercode;
    }

    public void setUsercode(String usercode) {
        this.usercode = usercode == null ? null : usercode.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department == null ? null : department.trim();
    }

    @Override
    public String toString() {
        return "User{" +
                "usercode='" + usercode + '\'' +
                ", username='" + username + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}