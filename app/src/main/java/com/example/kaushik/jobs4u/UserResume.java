package com.example.kaushik.jobs4u;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.ByteArrayOutputStream;
import java.util.List;

public class UserResume {
    String username;
    String fullname;
    String Father;
    String mother;
    String dob;
    String religion;
    String gender;
    String nationality;
    String career_objective;
    List<UserResume> resumeList;
    List<UserExperience> experienceList;
    List<UserSkill> skillList;
    Bitmap image;
    byte[] personal_image;

    public UserResume() {
    }

    public String getUsername() {

        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<UserResume> getResumeList() {
        return resumeList;
    }

    public void setResumeList(List<UserResume> resumeList) {
        this.resumeList = resumeList;
    }

    public List<UserExperience> getExperienceList() {
        return experienceList;
    }

    public void setExperienceList(List<UserExperience> experienceList) {
        this.experienceList = experienceList;
    }

    public List<UserSkill> getSkillList() {
        return skillList;
    }

    public void setSkillList(List<UserSkill> skillList) {
        this.skillList = skillList;
    }


    public String getFather() {
        return Father;
    }

    public void setFather(String father) {
        Father = father;
    }

    public String getMother() {
        return mother;
    }

    public void setMother(String mother) {
        this.mother = mother;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getCareer_objective() {
        return career_objective;
    }

    public void setCareer_objective(String career_objective) {
        this.career_objective = career_objective;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    public byte[] getPersonal_image() {
        return personal_image;
    }

    public void setPersonal_image(byte[] personal_image) {
        this.personal_image = personal_image;
    }

    public String getFullname() {

        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }



    public static byte[] getBytes(Bitmap bitmap) {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 0, stream);
        return stream.toByteArray();
    }

    public static Bitmap getImage(byte[] image) {
        return BitmapFactory.decodeByteArray(image, 0, image.length);
    }
}
