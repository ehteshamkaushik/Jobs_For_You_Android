package com.example.kaushik.jobs4u;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

/**
 * Created by Kaushik on 6/6/2017.
 */

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {
    AppCompatActivity activity = RegisterActivity.this;
    EditText signupusername, signupemail, signuppassword, confirmpassword;
    Button signupbutton, signuptologin;

    DatabaseHelper databasehelper;
    User user;


    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getSupportActionBar().hide();

        initViews();
        initListeners();
        initObjects();
    }

    private void initViews() {
        signupusername = (EditText) findViewById(R.id.signupusername);
        signupemail = (EditText) findViewById(R.id.signupemail);
        signuppassword = (EditText) findViewById(R.id.signuppassword);
        confirmpassword = (EditText) findViewById(R.id.confirmpassword);

        signupbutton = (Button) findViewById(R.id.signupbutton);
        signuptologin = (Button) findViewById(R.id.signuptologin);
    }

    private void initListeners() {
        signupbutton.setOnClickListener(this);
        signuptologin.setOnClickListener(this);
    }

    private void initObjects() {
        databasehelper = new DatabaseHelper(activity);
        user = new User();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.signupbutton:
                postDataToSQLite();
                break;

            case R.id.signuptologin:
                List<User> users = databasehelper.getAllUser();
                for (int i = 0; i < users.size(); i++)
                {
                    System.out.println(users.get(i).getName());
                }
                Intent intentLogin = new Intent(getApplicationContext(), loginActivity.class);
                startActivity(intentLogin);
                break;
        }
    }


    private void postDataToSQLite() {
        String username = signupusername.getText().toString().trim();
        String password = signuppassword.getText().toString().trim();
        String email = signupemail.getText().toString().trim();
        String confirmdpassword = confirmpassword.getText().toString().trim();
        String errormsg;
        if (username.equals("")) {
            errormsg = "Please Enter Username";
            Toast.makeText(this, errormsg, Toast.LENGTH_LONG).show();
            return;
        }
        if (email.equals("")) {
            errormsg = "Please Enter Email";
            Toast.makeText(this, errormsg, Toast.LENGTH_LONG).show();
            return;
        }
        if (password.equals("")) {
            errormsg = "Please Enter Password";
            Toast.makeText(this, errormsg, Toast.LENGTH_LONG).show();
            return;
        }

        if (confirmdpassword.equals("")) {
            errormsg = "Please Enter Password to Confirm";
            Toast.makeText(this, errormsg, Toast.LENGTH_LONG).show();
            return;
        }
        if (!password.equals(confirmdpassword)) {
            errormsg = "Please Confirm Password";
            Toast.makeText(this, errormsg, Toast.LENGTH_LONG).show();
            return;
        }

        if (!databasehelper.checkUser(username)){

            user.setName(username);
            user.setEmail(email);
            user.setPassword(password);

            databasehelper.addUser(user);
            System.out.println("Insert ");

            Toast.makeText(this, "Welcome " + username, Toast.LENGTH_LONG).show();
            return;
        } else {
            // Snack Bar to show error message that record already exists
            errormsg = "Username already exists";
            Toast.makeText(this, errormsg, Toast.LENGTH_LONG).show();
            return;
        }
    }
}
