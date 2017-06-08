package com.example.kaushik.jobs4u;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

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
        Toast.makeText(this, "Welcome " + usernametext, Toast.LENGTH_LONG).show();

        usernameview.setText(usernametext);

        TextView forum = (TextView)findViewById(R.id.forum);
        forum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), ForumActivity.class);
                startActivity(i);
            }
        });
        TextView myActivity = (TextView)findViewById(R.id.myActivity);
        myActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MyActivityActivity.class);
                startActivity(i);
            }
        });
        TextView notification = (TextView)findViewById(R.id.notification);
        notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), NotificationActivity.class);
                startActivity(i);
            }
        });

        TextView resume = (TextView)findViewById(R.id.resume);
        resume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent resumeIntent = new Intent(UserProfileActivity.this, ResumeActivity.class);
                resumeIntent.putExtra("username", usernametext);
                startActivity(resumeIntent);
            }
        });
        TextView profileInfo = (TextView)findViewById(R.id.profile_info);
        profileInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent profileInfoIntent = new Intent(UserProfileActivity.this, ViewProfile.class);
                profileInfoIntent.putExtra("username", usernametext);
                startActivity(profileInfoIntent);
            }
        });

        TextView editprofile = (TextView)findViewById(R.id.edit_profile);
        editprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent editprofileIntent = new Intent(UserProfileActivity.this, EditProfile.class);
                editprofileIntent.putExtra("username", usernametext);
                startActivity(editprofileIntent);
            }
        });
        TextView logout = (TextView)findViewById(R.id.logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent loginintent = new Intent(UserProfileActivity.this, loginActivity.class);
                startActivity(loginintent);
            }
        });
    }
}
