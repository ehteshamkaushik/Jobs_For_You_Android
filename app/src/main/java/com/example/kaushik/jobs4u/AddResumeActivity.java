package com.example.kaushik.jobs4u;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Kaushik on 6/5/2017.
 */

public class AddResumeActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_resume);

        Button addEducation = (Button) findViewById(R.id.addeducation);
        addEducation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final LinearLayout education = (LinearLayout) findViewById(R.id.education);
                LinearLayout newEducation = new LinearLayout(v.getContext());
                newEducation.setOrientation(LinearLayout.HORIZONTAL);
                final TextView examination = new TextView(v.getContext());
                examination.setText("Examination");
                examination.setWidth(350);
                examination.setBackgroundResource(R.color.white);
                final TextView year = new TextView(v.getContext());
                year.setText("year");
                year.setBackgroundResource(R.color.white);
                year.setWidth(120);
                final TextView institute = new TextView(v.getContext());
                institute.setText("institute");
                institute.setBackgroundResource(R.color.white);
                institute.setWidth(400);
                final TextView grade = new TextView(v.getContext());
                grade.setHeight(100);
                grade.setText("grade");
                grade.setWidth(90);
                grade.setBackgroundResource(R.color.white);

                newEducation.addView(examination);
                newEducation.addView(year);
                newEducation.addView(institute);
                newEducation.addView(grade);
                education.addView(newEducation);
                final Dialog dialog = new Dialog(v.getContext());
                dialog.setContentView(R.layout.addeducationlayout);
                dialog.setTitle("Add education");

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
                        grade.setText(i.getText());
                        dialog.dismiss();
                    }
                });
                dialog.show();
                Window window = dialog.getWindow();
                window.setLayout(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT);
            }
        });
    }
    public void showDatePickerDialog(android.view.View v) {
        DatePickerFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }
}
