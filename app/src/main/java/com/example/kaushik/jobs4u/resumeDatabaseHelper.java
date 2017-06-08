package com.example.kaushik.jobs4u;

/**
 * Created by Kaushik on 6/7/2017.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.renderscript.Sampler;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class resumeDatabaseHelper extends SQLiteOpenHelper {

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "UserResumeManager";

    // User resume table names
    private static final String TABLE_USER_RESUME = "user_resume";
    private static final String TABLE_USER_RESUME_EDUCATION = "user_resume_education";
    private static final String TABLE_USER_RESUME_EXPERIENCE = "user_resume_experience";
    private static final String TABLE_USER_RESUME_SKILLS = "user_resume_skills";

    // UserResume Table Columns names
    private static final String COLUMN_USER_NAME = "user_name";
    private static final String COLUMN_USER_FULLNAME = "fullname";
    private static final String COLUMN_USER_FATHER = "father";
    private static final String COLUMN_USER_MOTHER = "mother";
    private static final String COLUMN_USER_DOB = "dob";
    private static final String COLUMN_USER_RELIGION = "religion";
    private static final String COLUMN_USER_GENDER = "gender";
    private static final String COLUMN_USER_NATIONALITY = "nationality";
    private static final String COLUMN_USER_OBJECTIVE = "objective";
    private static final String COLUMN_USER_IMAGE = "image_data";

    //education column names
    private static final String COLUMN_EDUCATION_NAME = "education_user_name";
    private static final String COLUMN_EDUCATION_EXAM = "education_exam";
    private static final String COLUMN_EDUCATION_YEAR = "education_year";
    private static final String COLUMN_EDUCATION_INSTITUTE = "education_institute";
    private static final String COLUMN_EDUCATION_GRADE = "education_user_grade";

    //experience column names
    private static final String COLUMN_EXPERIENCE_NAME = "experience_user_name";
    private static final String COLUMN_EXPERIENCE_COMPANY = "experience_company";
    private static final String COLUMN_EXPERIENCE_DESIGNATION = "experience_designation";
    private static final String COLUMN_EXPERIENCE_DURATION = "experience_duration";

    //skills column names
    private static final String COLUMN_SKILL_USERNAME = "skill_user_name";
    private static final String COLUMN_SKILL_NAME = "skill_name";
    private static final String COLUMN_SKILL_RECOGNITION = "skill_recognition";



    // create table sql query
    private String CREATE_USER_RESUME_TABLE = "CREATE TABLE " + TABLE_USER_RESUME + "("
            + COLUMN_USER_NAME + " TEXT PRIMARY KEY,"
            + COLUMN_USER_FULLNAME + " TEXT," + COLUMN_USER_FATHER + " TEXT, " +
            COLUMN_USER_MOTHER + " TEXT, " + COLUMN_USER_DOB + " TEXT, " +
            COLUMN_USER_RELIGION + " TEXT, " + COLUMN_USER_GENDER + " TEXT, " +
            COLUMN_USER_NATIONALITY + " TEXT, " + COLUMN_USER_OBJECTIVE + " TEXT, "
            + COLUMN_USER_IMAGE + " BLOB" +
            ")";

    private String CREATE_USER_RESUME_EDUCATION_TABLE = "CREATE TABLE " + TABLE_USER_RESUME_EDUCATION + "("
            + COLUMN_EDUCATION_NAME+ " TEXT,"
            + COLUMN_EDUCATION_EXAM + " TEXT," + COLUMN_EDUCATION_YEAR + " TEXT, " +
            COLUMN_EDUCATION_INSTITUTE + " TEXT, " + COLUMN_EDUCATION_GRADE + " TEXT" +
            ")";

    private String CREATE_USER_RESUME_EXPERIENCE_TABLE = "CREATE TABLE " + TABLE_USER_RESUME_EXPERIENCE + "("
            + COLUMN_EXPERIENCE_NAME+ " TEXT," + COLUMN_EXPERIENCE_COMPANY + " TEXT, "
            + COLUMN_EXPERIENCE_DESIGNATION + " TEXT," + COLUMN_EXPERIENCE_DURATION + " TEXT "+
            ")";

    private String CREATE_USER_RESUME_SKILLS_TABLE = "CREATE TABLE " + TABLE_USER_RESUME_SKILLS + "("
            + COLUMN_SKILL_USERNAME+ " TEXT,"
            + COLUMN_SKILL_NAME + " TEXT," + COLUMN_SKILL_RECOGNITION + " TEXT "+
            ")";

    // drop table sql query
    private String DROP_USER_TABLE = "DROP TABLE IF EXISTS " + TABLE_USER_RESUME;
    private String DROP_USER_EDUCATION_TABLE = "DROP TABLE IF EXISTS " + TABLE_USER_RESUME_EDUCATION;
    private String DROP_USER_EXPERIENCE_TABLE = "DROP TABLE IF EXISTS " + TABLE_USER_RESUME_EXPERIENCE;
    private String DROP_USER_SKILLS_TABLE = "DROP TABLE IF EXISTS " + TABLE_USER_RESUME_SKILLS;


    /**
     * Constructor
     *
     * @param context
     */
    public resumeDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_USER_RESUME_TABLE);
        db.execSQL(CREATE_USER_RESUME_EDUCATION_TABLE);
        db.execSQL(CREATE_USER_RESUME_EXPERIENCE_TABLE);
        db.execSQL(CREATE_USER_RESUME_SKILLS_TABLE);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        //Drop User Table if exist
        db.execSQL(DROP_USER_TABLE);
        db.execSQL(DROP_USER_EDUCATION_TABLE);
        db.execSQL(DROP_USER_EXPERIENCE_TABLE);
        db.execSQL(DROP_USER_SKILLS_TABLE);


        // Create tables again
        onCreate(db);

    }

    /**
     * This method is to create user record
     *
     * @paramuser
     */
    public void addUserResume(UserResume userResume) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_USER_NAME, userResume.getUsername());
        values.put(COLUMN_USER_FULLNAME, userResume.getFullname());
        values.put(COLUMN_USER_FATHER, userResume.getFather());
        values.put(COLUMN_USER_MOTHER, userResume.getMother());
        values.put(COLUMN_USER_DOB, userResume.getDob());
        values.put(COLUMN_USER_RELIGION, userResume.getReligion());
        values.put(COLUMN_USER_GENDER, userResume.getGender());
        values.put(COLUMN_USER_NATIONALITY, userResume.getNationality());
        values.put(COLUMN_USER_OBJECTIVE, userResume.getCareer_objective());
        values.put(COLUMN_USER_IMAGE, userResume.getBytes(userResume.getImage()));
        System.out.println(userResume.getUsername());
        System.out.println(userResume.getFullname());
        System.out.println(userResume.getFather());
        System.out.println(userResume.getMother());
        System.out.println(userResume.getDob());
        System.out.println(userResume.getReligion());
        System.out.println(userResume.getGender());
        System.out.println(userResume.getCareer_objective());
        System.out.println(userResume.getBytes(userResume.image));




        // Inserting Row
        long flag = db.insert(TABLE_USER_RESUME, null, values);
        //long rows=db.insertWithOnConflict(TABLE_USER_RESUME, null,  values,SQLiteDatabase.CONFLICT_REPLACE);
        db.close();
    }


    public void addUserEducation(UserEducation userEducation) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_EDUCATION_NAME, userEducation.getUsername());
        values.put(COLUMN_EDUCATION_EXAM, userEducation.getExamination());
        values.put(COLUMN_EDUCATION_YEAR, userEducation.getYear());
        values.put(COLUMN_EDUCATION_INSTITUTE, userEducation.getInstitute());
        values.put(COLUMN_EDUCATION_GRADE, userEducation.getGrade());

        // Inserting Row
        db.insert(TABLE_USER_RESUME_EDUCATION, null, values);
        //long rows=db.insertWithOnConflict(TABLE_USER_RESUME_EDUCATION, null,  values,SQLiteDatabase.CONFLICT_REPLACE);
        db.close();
    }
    public void addUserExperience(UserExperience userExperience) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_EXPERIENCE_NAME, userExperience.getUsername());
        values.put(COLUMN_EXPERIENCE_COMPANY, userExperience.getCompany());
        values.put(COLUMN_EXPERIENCE_DESIGNATION, userExperience.getDesignation());
        values.put(COLUMN_EXPERIENCE_DURATION, userExperience.getDuration());

        // Inserting Row
        db.insert(TABLE_USER_RESUME_EXPERIENCE, null, values);

        //long flag = db.insert(TABLE_USER_RESUME_EXPERIENCE, null, values);
       // long rows=db.insertWithOnConflict(TABLE_USER_RESUME_EXPERIENCE, null,  values,SQLiteDatabase.CONFLICT_REPLACE);
        db.close();
    }

    public void addUserSkills(UserSkill userSkill) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_SKILL_USERNAME, userSkill.getUsername());
        values.put(COLUMN_SKILL_NAME, userSkill.getSkillName());
        values.put(COLUMN_SKILL_RECOGNITION, userSkill.getRecognition());

        // Inserting Row
        db.insert(TABLE_USER_RESUME_SKILLS, null, values);
        //long flag = db.insert(TABLE_USER_RESUME_SKILLS, null, values);
        //long rows=db.insertWithOnConflict(TABLE_USER_RESUME_SKILLS, null,  values,SQLiteDatabase.CONFLICT_REPLACE);
        db.close();
    }

    public List<UserResume> getAllUser() {
        String[] columns = {
                COLUMN_USER_NAME,
                COLUMN_USER_FULLNAME,
                COLUMN_USER_FATHER,
                COLUMN_USER_MOTHER,
                COLUMN_USER_DOB,
                COLUMN_USER_RELIGION,
                COLUMN_USER_GENDER,
                COLUMN_USER_NATIONALITY,
                COLUMN_USER_OBJECTIVE,
                COLUMN_USER_IMAGE
        };
        String sortOrder =
                COLUMN_USER_NAME + " ASC";
        List<UserResume> userResumes = new ArrayList<UserResume>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_USER_RESUME, //Table to query
                columns,    //columns to return
                null,        //columns for the WHERE clause
                null,        //The values for the WHERE clause
                null,       //group the rows
                null,       //filter by row groups
                sortOrder); //The sort order


        // Traversing through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                UserResume userResume = new UserResume();
                userResume.setUsername(cursor.getString(cursor.getColumnIndex(COLUMN_USER_NAME)));
                userResume.setFullname(cursor.getString(cursor.getColumnIndex(COLUMN_USER_FULLNAME)));
                userResume.setFather(cursor.getString(cursor.getColumnIndex(COLUMN_USER_FATHER)));
                userResume.setReligion(cursor.getString(cursor.getColumnIndex(COLUMN_USER_RELIGION)));
                // Adding user record to list
                userResumes.add(userResume);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();

        // return user list
        return userResumes;
    }

    public static boolean doesDatabaseExists(Context context, String dbName)
    {
        File dbFile = context.getDatabasePath(dbName);
        return dbFile.exists();
    }


    public List<UserEducation> getAllEducation(String username) {
        String[] columns = {
                COLUMN_EDUCATION_NAME,
                COLUMN_EDUCATION_EXAM,
                COLUMN_EDUCATION_YEAR,
                COLUMN_EDUCATION_INSTITUTE,
                COLUMN_EDUCATION_GRADE
        };
        String sortOrder =
                COLUMN_EDUCATION_NAME + " ASC";
        String selection = COLUMN_EDUCATION_NAME + " = ?";
        String[] selectionArgs = { username };
        List<UserEducation> userEducationList = new ArrayList<UserEducation>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_USER_RESUME_EDUCATION, //Table to query
                columns,    //columns to return
                selection,        //columns for the WHERE clause
                selectionArgs,        //The values for the WHERE clause
                null,       //group the rows
                null,       //filter by row groups
                sortOrder); //The sort order


        // Traversing through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                UserEducation userEducation = new UserEducation();
                userEducation.setUsername(cursor.getString(cursor.getColumnIndex(COLUMN_EDUCATION_NAME)));
                userEducation.setExamination(cursor.getString(cursor.getColumnIndex(COLUMN_EDUCATION_EXAM)));
                userEducation.setYear(cursor.getString(cursor.getColumnIndex(COLUMN_EDUCATION_YEAR)));
                userEducation.setInstitute(cursor.getString(cursor.getColumnIndex(COLUMN_EDUCATION_INSTITUTE)));
                userEducation.setGrade(cursor.getString(cursor.getColumnIndex(COLUMN_EDUCATION_GRADE)));
                // Adding user record to list
                userEducationList.add(userEducation);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();

        // return user list
        return userEducationList;
    }


    public List<UserExperience> getAllExperience(String username) {
        String[] columns = {
                COLUMN_EXPERIENCE_NAME,
                COLUMN_EXPERIENCE_COMPANY,
                COLUMN_EXPERIENCE_DESIGNATION,
                COLUMN_EXPERIENCE_DURATION
        };
        String sortOrder =
                COLUMN_EXPERIENCE_NAME + " ASC";
        String selection = COLUMN_EXPERIENCE_NAME + " = ?";
        String[] selectionArgs = { username };
        List<UserExperience> userExperienceList = new ArrayList<UserExperience>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_USER_RESUME_EXPERIENCE, //Table to query
                columns,    //columns to return
                selection,        //columns for the WHERE clause
                selectionArgs,        //The values for the WHERE clause
                null,       //group the rows
                null,       //filter by row groups
                sortOrder); //The sort order


        // Traversing through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                UserExperience userExperience = new UserExperience();
                userExperience.setUsername(cursor.getString(cursor.getColumnIndex(COLUMN_EXPERIENCE_NAME)));
                userExperience.setCompany(cursor.getString(cursor.getColumnIndex(COLUMN_EXPERIENCE_COMPANY)));
                userExperience.setDesignation(cursor.getString(cursor.getColumnIndex(COLUMN_EXPERIENCE_DESIGNATION)));
                userExperience.setDuration(cursor.getString(cursor.getColumnIndex(COLUMN_EXPERIENCE_DURATION)));
                // Adding user record to list
                userExperienceList.add(userExperience);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();

        // return user list
        return userExperienceList;
    }


    public List<UserSkill> getAllSkills(String username) {
        String[] columns = {
                COLUMN_SKILL_USERNAME,
                COLUMN_SKILL_NAME,
                COLUMN_SKILL_RECOGNITION
        };
        String sortOrder =
                COLUMN_SKILL_USERNAME + " ASC";
        String selection = COLUMN_SKILL_USERNAME + " = ?";
        String[] selectionArgs = { username };
        List<UserSkill> userSkillList = new ArrayList<UserSkill>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_USER_RESUME_SKILLS, //Table to query
                columns,    //columns to return
                selection,        //columns for the WHERE clause
                selectionArgs,        //The values for the WHERE clause
                null,       //group the rows
                null,       //filter by row groups
                sortOrder); //The sort order


        // Traversing through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                UserSkill userSkill = new UserSkill();
                userSkill.setUsername(cursor.getString(cursor.getColumnIndex(COLUMN_SKILL_USERNAME)));
                userSkill.setSkillName(cursor.getString(cursor.getColumnIndex(COLUMN_SKILL_NAME)));
                userSkill.setRecognition(cursor.getString(cursor.getColumnIndex(COLUMN_SKILL_RECOGNITION)));
                // Adding user record to list
                userSkillList.add(userSkill);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();

        // return user list
        return userSkillList;
    }
    public List<UserResume> getaUser(String username) {
        // array of columns to fetch
        String[] columns = {
                COLUMN_USER_NAME,
                COLUMN_USER_FULLNAME,
                COLUMN_USER_FATHER,
                COLUMN_USER_MOTHER,
                COLUMN_USER_DOB,
                COLUMN_USER_RELIGION,
                COLUMN_USER_GENDER,
                COLUMN_USER_NATIONALITY,
                COLUMN_USER_OBJECTIVE,
                COLUMN_USER_IMAGE
        };
        // sorting orders
        String sortOrder =
                COLUMN_USER_NAME + " ASC";
        List<UserResume> userResumes = new ArrayList<UserResume>();

        SQLiteDatabase db = this.getReadableDatabase();

        String selection = COLUMN_USER_NAME + " = ?";
        String[] selectionArgs = { username };
        Cursor cursor = db.query(TABLE_USER_RESUME, //Table to query
                columns,    //columns to return
                selection,        //columns for the WHERE clause
                selectionArgs,        //The values for the WHERE clause
                null,       //group the rows
                null,       //filter by row groups
                sortOrder); //The sort order


        // Traversing through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                UserResume userResume = new UserResume();
                userResume.setUsername(cursor.getString(cursor.getColumnIndex(COLUMN_USER_NAME)));
                userResume.setFullname(cursor.getString(cursor.getColumnIndex(COLUMN_USER_FULLNAME)));
                userResume.setFather(cursor.getString(cursor.getColumnIndex(COLUMN_USER_FATHER)));
                userResume.setMother(cursor.getString(cursor.getColumnIndex(COLUMN_USER_MOTHER)));
                userResume.setReligion(cursor.getString(cursor.getColumnIndex(COLUMN_USER_RELIGION)));
                userResume.setGender(cursor.getString(cursor.getColumnIndex(COLUMN_USER_GENDER)));
                userResume.setNationality(cursor.getString(cursor.getColumnIndex(COLUMN_USER_NATIONALITY)));
                userResume.setDob(cursor.getString(cursor.getColumnIndex(COLUMN_USER_DOB)));
                userResume.setCareer_objective(cursor.getString(cursor.getColumnIndex(COLUMN_USER_OBJECTIVE)));
                byte[] image_data = cursor.getBlob(cursor.getColumnIndex(COLUMN_USER_IMAGE));
                userResume.setImage(userResume.getBitmap(image_data));


                // Adding user record to list
                userResumes.add(userResume);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();

        // return user list
        return userResumes;
    }

    public boolean checkUser(String username) {

        // array of columns to fetch
        String[] columns = {
                COLUMN_USER_NAME
        };
        SQLiteDatabase db = this.getReadableDatabase();

        // selection criteria
        String selection = COLUMN_USER_NAME + " = ?";

        // selection argument
        String[] selectionArgs = {username};

        // query user table with condition
        /**
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT user_id FROM user WHERE user_email = 'jack@androidtutorialshub.com';
         */
        Cursor cursor = db.query(TABLE_USER_RESUME, //Table to query
                columns,                    //columns to return
                selection,                  //columns for the WHERE clause
                selectionArgs,              //The values for the WHERE clause
                null,                       //group the rows
                null,                      //filter by row groups
                null);                      //The sort order
        int cursorCount = cursor.getCount();
        cursor.close();
        db.close();

        if (cursorCount > 0) {
            return true;
        }

        return false;
    }



    public void deleteUser(String username) {
        SQLiteDatabase db = this.getWritableDatabase();
        // delete user record by id
        db.delete(TABLE_USER_RESUME, COLUMN_USER_NAME + " = ?", new String[]{username});
        db.close();
    }

    public void deleteUsereducation(String username) {
        SQLiteDatabase db = this.getWritableDatabase();
        // delete user record by id
        db.delete(TABLE_USER_RESUME_EDUCATION, COLUMN_EDUCATION_NAME + " = ?", new String[]{username});
        db.close();
    }
    public void deleteUserExperience(String username) {
        SQLiteDatabase db = this.getWritableDatabase();
        // delete user record by id
        db.delete(TABLE_USER_RESUME_EXPERIENCE, COLUMN_EXPERIENCE_NAME + " = ?", new String[]{username});
        db.close();
    }

    public void deleteUserSkills(String username) {
        SQLiteDatabase db = this.getWritableDatabase();
        // delete user record by id
        db.delete(TABLE_USER_RESUME_SKILLS, COLUMN_SKILL_USERNAME + " = ?", new String[]{username});
        db.close();
    }



    public void updateUser(User user) {
        /*SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_USER_NAME, user.getName());
        values.put(COLUMN_USER_EMAIL, user.getEmail());
        values.put(COLUMN_USER_PASSWORD, user.getPassword());

        // updating row
        db.update(TABLE_USER, values, COLUMN_USER_ID + " = ?",
                new String[]{String.valueOf(user.getId())});
        db.close();*/
    }
}
