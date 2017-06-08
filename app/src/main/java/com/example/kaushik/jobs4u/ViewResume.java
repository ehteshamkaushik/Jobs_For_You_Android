package com.example.kaushik.jobs4u;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kaushik on 6/8/2017.
 */

public class ViewResume extends AppCompatActivity{
    String usernametext;
    UserResume resume;
    resumeDatabaseHelper resumeDatabaseHelper;
    List<UserResume> resumeList = new ArrayList<>();
    List<UserEducation> educationList = new ArrayList<>();
    List<UserExperience> experienceList = new ArrayList<>();
    List<UserSkill> skillList = new ArrayList<>();

    TextView fullname, father, mother , religion, gender, objective, nationality, dob;
    ImageView image;
    TableLayout education, experience, skill;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_resume);
        Intent intent = getIntent();
        usernametext = intent.getStringExtra("username");
        initViews();
        initObjects();

        Toast.makeText(this, usernametext, Toast.LENGTH_LONG).show();

        resumeList = resumeDatabaseHelper.getaUser(usernametext);
        educationList = resumeDatabaseHelper.getAllEducation(usernametext);
        experienceList = resumeDatabaseHelper.getAllExperience(usernametext);
        skillList = resumeDatabaseHelper.getAllSkills(usernametext);

        resume = resumeList.get(0);

        fullname.setText(resume.getFullname());
        father.setText(resume.getFather());
        mother.setText(resume.getMother());
        String date = resume.getDob();
        String[] splited = date.split("\\s+");
        dob.setText(splited[0] + " " + splited[1] + ", " + splited[2]);
        religion.setText(resume.getReligion());
        gender.setText(resume.getGender());
        nationality.setText(resume.getNationality());
        objective.setText(resume.getCareer_objective());
        image.setImageBitmap(resume.getImage());
        addEducation();
        addExperience();
        addSkill();
    }


    private void initViews() {
        fullname = (TextView) findViewById(R.id.fullnameview);
        father = (TextView) findViewById(R.id.fatherview);
        mother = (TextView) findViewById(R.id.motherview);
        dob = (TextView) findViewById(R.id.dob_view);
        religion = (TextView) findViewById(R.id.religionview);
        gender = (TextView) findViewById(R.id.genderview);
        nationality = (TextView)findViewById(R.id.nationalityview);
        objective = (TextView) findViewById(R.id.objectiveview);
        image = (ImageView) findViewById(R.id.personalimageview);
        education = (TableLayout) findViewById(R.id.table_education_view);
        experience = (TableLayout) findViewById(R.id.table_experience_view);
        skill = (TableLayout) findViewById(R.id.table_skills_view);
    }

    private void initObjects() {
        resumeDatabaseHelper = new resumeDatabaseHelper(ViewResume.this);
        resume = new UserResume();
    }


    private void addEducation() {
        final float scale = getResources().getDisplayMetrics().density;
        int pixels = (int) (50 * scale + 0.5f);
        for (int i = 0; i < educationList.size(); i++) {

            final TableRow newEducation = new TableRow(this);
            newEducation.setPadding(0, 0, (int) (1 * scale + 0.5f), (int) (1 * scale + 0.5f));

            final TextView examination = new TextView(this);
            examination.setBackgroundResource(R.color.white);
            examination.setWidth(pixels);

            final TextView year = new TextView(this);
            year.setBackgroundResource(R.color.white);

            final TextView institute = new TextView(this);
            institute.setBackgroundResource(R.color.white);
            institute.setWidth(pixels);

            final TextView grade = new TextView(this);
            grade.setBackgroundResource(R.color.white);

            examination.setText(educationList.get(i).getExamination());
            year.setText(educationList.get(i).getYear());
            institute.setText(educationList.get(i).getInstitute());
            grade.setText(educationList.get(i).getGrade());
            newEducation.addView(examination);
            newEducation.addView(year);
            newEducation.addView(institute);
            newEducation.addView(grade);
            education.addView(newEducation);
        }
    }

    private void addExperience() {
        final float scale = getResources().getDisplayMetrics().density;
        int pixels = (int) (50 * scale + 0.5f);
        for (int i = 0; i < experienceList.size(); i++) {

            final TableRow newExperience = new TableRow(this);
            newExperience.setPadding(0, 0, (int) (1 * scale + 0.5f), (int) (1 * scale + 0.5f));

            final TextView company = new TextView(this);
            company.setBackgroundResource(R.color.white);
            company.setWidth(pixels);

            final TextView designation = new TextView(this);
            designation.setBackgroundResource(R.color.white);
            designation.setWidth(pixels);

            final TextView duration = new TextView(this);
            duration.setBackgroundResource(R.color.white);

            company.setText(experienceList.get(i).getCompany());
            designation.setText(experienceList.get(i).getDesignation());
            duration.setText(experienceList.get(i).getDuration());

            newExperience.addView(company);
            newExperience.addView(designation);
            newExperience.addView(duration);

            experience.addView(newExperience);
        }
    }

    private void addSkill() {
        final float scale = getResources().getDisplayMetrics().density;
        int pixels = (int) (50 * scale + 0.5f);
        for (int i = 0; i < skillList.size(); i++) {

            final TableRow newSkill = new TableRow(this);
            newSkill.setPadding(0, 0, (int) (1 * scale + 0.5f), (int) (1 * scale + 0.5f));

            final TextView skillName = new TextView(this);
            skillName.setBackgroundResource(R.color.white);
            skillName.setWidth(pixels);

            final TextView recognition = new TextView(this);
            recognition.setBackgroundResource(R.color.white);
            recognition.setWidth(pixels);

            skillName.setText(skillList.get(i).getSkillName());
            recognition.setText(skillList.get(i).getRecognition());

            newSkill.addView(skillName);
            newSkill.addView(recognition);

            skill.addView(newSkill);
        }
    }

}
