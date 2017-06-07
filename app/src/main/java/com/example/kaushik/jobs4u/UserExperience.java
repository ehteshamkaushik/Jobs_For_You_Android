package com.example.kaushik.jobs4u;

public class UserExperience
{
    String username;

    public UserExperience(String username, String company, String designation, String duration) {
        this.username = username;
        this.company = company;
        this.designation = designation;
        this.duration = duration;
    }

    public UserExperience() {

    }

    public String getUsername() {

        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    String company;
    String designation;
    String duration;
}
