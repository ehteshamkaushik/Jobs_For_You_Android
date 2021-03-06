package com.example.kaushik.jobs4u;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.util.List;

/**
 * Created by Kaushik on 6/5/2017.
 */

public class ResumeActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resume_main);

        Intent intent = getIntent();
        final String usernametext = intent.getStringExtra("username");

        TextView addresume = (TextView) findViewById(R.id.addresume);
        addresume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resumeDatabaseHelper db = new resumeDatabaseHelper(ResumeActivity.this);
                if(db.checkUser(usernametext)){
                    Toast.makeText(view.getContext(), "Resume Already Added", Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent addResumeIntent = new Intent(ResumeActivity.this, Resume_form.class);
                    addResumeIntent.putExtra("username", usernametext);
                    startActivity(addResumeIntent);
                }
            }
        });

        TextView viewresume = (TextView) findViewById(R.id.viewresume);
        viewresume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resumeDatabaseHelper db = new resumeDatabaseHelper(ResumeActivity.this);
                if(db.checkUser(usernametext))
                {
                    Intent viewResume = new Intent(ResumeActivity.this, ViewResume.class);
                    viewResume.putExtra("username", usernametext);
                    startActivity(viewResume);
                }
                else
                {
                    Toast.makeText(view.getContext(), "Add your resume first", Toast.LENGTH_SHORT).show();
                }

            }
        });
        TextView editresume = (TextView) findViewById(R.id.edit_resume);
        editresume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resumeDatabaseHelper db = new resumeDatabaseHelper(ResumeActivity.this);
                if(db.checkUser(usernametext))
                {
                    Intent editresume = new Intent(ResumeActivity.this, EditResume.class);
                    editresume.putExtra("username", usernametext);
                    startActivity(editresume);
                }
                else
                {
                    Toast.makeText(v.getContext(), "Add your resume first", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}
