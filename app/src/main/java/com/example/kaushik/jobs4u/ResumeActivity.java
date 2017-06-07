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
                Intent addResumeIntent = new Intent(ResumeActivity.this, Resume_form.class);
                addResumeIntent.putExtra("username", usernametext);
                startActivity(addResumeIntent);
            }
        });

        TextView viewresume = (TextView) findViewById(R.id.viewresume);
        viewresume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resumeDatabaseHelper db = new resumeDatabaseHelper(ResumeActivity.this);
                boolean exs= db.doesDatabaseExists(ResumeActivity.this, "UserResumeManager.db");
                System.out.println("database exists : " + exs);
                List<UserResume> all = db.getAllUser();
                for (int i = 0; i < all.size(); i++)
                {
                    System.out.println(all.get(i).username + " " + all.get(i).dob);
                }
                if(db.checkUser(usernametext))
                {
                    Toast.makeText(view.getContext(), "Found", Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(view.getContext(), "Not Found", Toast.LENGTH_LONG).show();
                }
            }
        });


    }
}
