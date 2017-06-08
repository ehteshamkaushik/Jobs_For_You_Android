package com.example.kaushik.jobs4u;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TableLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kaushik on 6/8/2017.
 */

public class ViewProfile extends AppCompatActivity {
    String usernametext;
    TextView username, password, address, mobile, email;
    User user;
    DatabaseHelper databaseHelper;
    List<User> userList = new ArrayList<>();
    TableLayout education, experience, skill;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_profile);
        Intent intent = getIntent();
        usernametext = intent.getStringExtra("username");
        initViews();
        initObjects();
        show();
    }

    private void show() {
        userList = databaseHelper.getAUser(usernametext);
        user = userList.get(0);
        username.setText(user.getName());
        email.setText(user.getEmail());
        address.setText(user.getAddress());
        mobile.setText(user.getMobile());
        String pw = "";
        for (int i = 0; i < user.getPassword().length(); i++)
            pw+= "*";
        password.setText(pw);
    }

    private void initObjects() {
        user = new User();
        databaseHelper = new DatabaseHelper(ViewProfile.this);
    }

    private void initViews() {
        username = (TextView) findViewById(R.id.profile_username);
        password = (TextView) findViewById(R.id.profile_password);
        address = (TextView) findViewById(R.id.profile_adddress);
        mobile = (TextView) findViewById(R.id.profile_mobile);
        email = (TextView) findViewById(R.id.profile_email);
    }
}
