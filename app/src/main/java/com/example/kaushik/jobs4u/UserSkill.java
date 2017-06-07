package com.example.kaushik.jobs4u;

/**
 * Created by Kaushik on 6/7/2017.
 */

public class UserSkill {
    String username;

    public UserSkill(String username, String skillName, String recognition) {
        this.username = username;
        this.skillName = skillName;
        Recognition = recognition;
    }

    public UserSkill() {

    }

    public String getUsername() {

        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public String getRecognition() {
        return Recognition;
    }

    public void setRecognition(String recognition) {
        Recognition = recognition;
    }

    String skillName;
    String Recognition;
}
