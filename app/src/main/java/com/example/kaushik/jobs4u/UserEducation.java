package com.example.kaushik.jobs4u;

/**
 * Created by Kaushik on 6/7/2017.
 */
public class UserEducation
{
    String username;

    public UserEducation() {
    }

    public UserEducation(String username, String examination, String year, String institute, String grade) {

        this.username = username;
        this.examination = examination;
        this.year = year;
        this.institute = institute;
        this.grade = grade;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getExamination() {
        return examination;
    }

    public void setExamination(String examination) {
        this.examination = examination;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getInstitute() {
        return institute;
    }

    public void setInstitute(String institute) {
        this.institute = institute;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    String examination;
    String year;
    String institute;
    String grade;
}
