package com.example.kaushik.jobs4u;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.io.FileNotFoundException;
import java.io.IOException;

import static android.R.attr.data;
import static java.security.AccessController.getContext;

/**
 * Created by Kaushik on 6/6/2017.
 */

public class Resume_form extends AppCompatActivity {

    final int GET_FROM_GALLERY = 3;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_resume);




        final Button adddate = (Button) findViewById(R.id.adddate);
        adddate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(v.getContext());
                dialog.setContentView(R.layout.adddatelayout);
                dialog.setTitle("Add Date");

                final float scale = getResources().getDisplayMetrics().density;
                int pixels = (int) (50 * scale + 0.5f);

                final TableLayout DateTable = (TableLayout) findViewById(R.id.table_dob);
                final TableRow date = new TableRow(v.getContext());
                date.setPadding(0, 0, (int) (1 * scale + 0.5f), (int) (1 * scale + 0.5f));


                final TextView day = new TextView(v.getContext());
                day.setBackgroundResource(R.color.white);
                day.setWidth(pixels);

                final TextView year = new TextView(v.getContext());
                year.setBackgroundResource(R.color.white);
                year.setWidth(pixels);

                final TextView month = new TextView(v.getContext());
                month.setBackgroundResource(R.color.white);
                month.setWidth(pixels);



                final EditText d = (EditText) dialog.findViewById(R.id.d);
                final EditText y = (EditText) dialog.findViewById(R.id.yr);
                final EditText m = (EditText) dialog.findViewById(R.id.m);

                final Button addbutton = (Button) dialog.findViewById(R.id.adddatebutton);
                addbutton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        day.setText(d.getText());
                        year.setText(y.getText());
                        month.setText(m.getText());

                        date.addView(day);
                        date.addView(month);
                        date.addView(year);

                        DateTable.addView(date);
                        adddate.setVisibility(View.INVISIBLE);
                        dialog.dismiss();
                    }
                });
                dialog.show();
                Window window = dialog.getWindow();
                window.setLayout(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT);
            }
        });

        Button addEducation = (Button) findViewById(R.id.addeducation1);
        addEducation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(v.getContext());
                dialog.setContentView(R.layout.addeducationlayout);
                dialog.setTitle("Add education");

                final float scale = getResources().getDisplayMetrics().density;
                int pixels = (int) (50 * scale + 0.5f);

                final TableLayout EducationTable = (TableLayout) findViewById(R.id.table_education);
                final TableRow newEducation = new TableRow(v.getContext());
                newEducation.setPadding(0, 0, (int) (1 * scale + 0.5f), (int) (1 * scale + 0.5f));


                final TextView examination = new TextView(v.getContext());
                examination.setBackgroundResource(R.color.white);
                examination.setWidth(pixels);

                final TextView year = new TextView(v.getContext());
                year.setBackgroundResource(R.color.white);

                final TextView institute = new TextView(v.getContext());
                institute.setBackgroundResource(R.color.white);
                institute.setWidth(pixels);

                final TextView grade = new TextView(v.getContext());
                grade.setBackgroundResource(R.color.white);


                final EditText e = (EditText) dialog.findViewById(R.id.edu);
                final EditText y = (EditText) dialog.findViewById(R.id.y);
                final EditText i = (EditText) dialog.findViewById(R.id.inst);
                final EditText g = (EditText) dialog.findViewById(R.id.g);
                Button addbutton = (Button) dialog.findViewById(R.id.addbutton);
                addbutton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        examination.setText(e.getText());
                        year.setText(y.getText());
                        institute.setText(i.getText());
                        grade.setText(g.getText());
                        newEducation.addView(examination);
                        newEducation.addView(year);
                        newEducation.addView(institute);
                        newEducation.addView(grade);
                        EducationTable.addView(newEducation);
                        dialog.dismiss();
                    }
                });
                dialog.show();
                Window window = dialog.getWindow();
                window.setLayout(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT);
            }
        });


        Button addExperience = (Button) findViewById(R.id.addexperience);
        addExperience.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(v.getContext());
                dialog.setContentView(R.layout.addexperiencelayout);
                dialog.setTitle("Add Experience");

                final float scale = getResources().getDisplayMetrics().density;
                int pixels = (int) (50 * scale + 0.5f);

                final TableLayout ExperienceTable = (TableLayout) findViewById(R.id.table_experience);
                final TableRow newExperience = new TableRow(v.getContext());
                newExperience.setPadding(0, 0, (int) (1 * scale + 0.5f), (int) (1 * scale + 0.5f));


                final TextView company = new TextView(v.getContext());
                company.setBackgroundResource(R.color.white);
                company.setWidth(pixels);

                final TextView designation = new TextView(v.getContext());
                designation.setBackgroundResource(R.color.white);

                final TextView duration = new TextView(v.getContext());
                duration.setBackgroundResource(R.color.white);
                duration.setWidth(pixels);


                final EditText c = (EditText) dialog.findViewById(R.id.com);
                final EditText des = (EditText) dialog.findViewById(R.id.des);
                final EditText dur = (EditText) dialog.findViewById(R.id.dur);
                Button addbutton = (Button) dialog.findViewById(R.id.addexpbutton);
                addbutton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        company.setText(c.getText());
                        designation.setText(des.getText());
                        duration.setText(dur.getText());
                        newExperience.addView(company);
                        newExperience.addView(designation);
                        newExperience.addView(duration);
                        ExperienceTable.addView(newExperience);
                        dialog.dismiss();
                    }
                });
                dialog.show();
                Window window = dialog.getWindow();
                window.setLayout(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT);
            }
        });


        Button addSkill = (Button) findViewById(R.id.addskill);
        addSkill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(v.getContext());
                dialog.setContentView(R.layout.addskilllayout);
                dialog.setTitle("Add Skill");

                final float scale = getResources().getDisplayMetrics().density;
                int pixels = (int) (50 * scale + 0.5f);

                final TableLayout SkillTable = (TableLayout) findViewById(R.id.table_skills);
                final TableRow newSkill = new TableRow(v.getContext());
                newSkill.setPadding(0, 0, (int) (1 * scale + 0.5f), (int) (1 * scale + 0.5f));


                final TextView skill = new TextView(v.getContext());
                skill.setBackgroundResource(R.color.white);
                skill.setWidth(pixels);

                final TextView recognition = new TextView(v.getContext());
                recognition.setBackgroundResource(R.color.white);
                recognition.setWidth(pixels);


                final EditText s = (EditText) dialog.findViewById(R.id.skl);
                final EditText r = (EditText) dialog.findViewById(R.id.rec);

                Button addbutton = (Button) dialog.findViewById(R.id.addskillbutton);
                addbutton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        skill.setText(s.getText());
                        recognition.setText(r.getText());
                        newSkill.addView(skill);
                        newSkill.addView(recognition);
                        SkillTable.addView(newSkill);
                        dialog.dismiss();
                    }
                });
                dialog.show();
                Window window = dialog.getWindow();
                window.setLayout(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT);
            }
        });

        Button addimage = (Button) findViewById(R.id.addimage);
        addimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivityForResult(new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.INTERNAL_CONTENT_URI),
                        GET_FROM_GALLERY);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        //Detects request codes
        if(requestCode==GET_FROM_GALLERY && resultCode == Activity.RESULT_OK) {
            Uri selectedImage = data.getData();
            Bitmap bitmap = null;
            try {
                bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), selectedImage);
                bitmap = decodeUri(this, selectedImage, 300);
                ImageButton imageButton = (ImageButton) findViewById(R.id.myButton);

                imageButton.setImageBitmap(bitmap);
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public static Bitmap decodeUri(Context c, Uri uri, final int requiredSize)
            throws FileNotFoundException {
        BitmapFactory.Options o = new BitmapFactory.Options();
        o.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(c.getContentResolver().openInputStream(uri), null, o);

        int width_tmp = o.outWidth
                , height_tmp = o.outHeight;
        int scale = 1;

        while(true) {
            if(width_tmp / 2 < requiredSize || height_tmp / 2 < requiredSize)
                break;
            width_tmp /= 2;
            height_tmp /= 2;
            scale *= 2;
        }

        BitmapFactory.Options o2 = new BitmapFactory.Options();
        o2.inSampleSize = scale;
        return BitmapFactory.decodeStream(c.getContentResolver().openInputStream(uri), null, o2);
    }
}

