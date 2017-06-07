package com.example.kaushik.jobs4u;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Kaushik on 6/5/2017.
 */

public class UserProfileActivity extends AppCompatActivity {
    TextView usernameview;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_profile_layout);
        Intent intent = getIntent();
        final String usernametext = intent.getStringExtra("user");
        usernameview = (TextView) findViewById(R.id.user);

        usernameview.setText(usernametext);

        TextView resume = (TextView)findViewById(R.id.resume);
        resume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent resumeIntent = new Intent(UserProfileActivity.this, ResumeActivity.class);
                resumeIntent.putExtra("username", usernametext);
                startActivity(resumeIntent);
            }
        });
    }
}
