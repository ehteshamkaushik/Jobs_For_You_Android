package com.example.kaushik.jobs4u;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Kaushik on 6/5/2017.
 */

public class loginActivity extends AppCompatActivity implements View.OnClickListener{
    EditText loginusername;
    EditText loginpassword;
    Button loginButton, logintosignup;
    DatabaseHelper databaseHelper;
    InputValidation inputValidation;
    AppCompatActivity activity = loginActivity.this;
    String errormsg;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);

        initViews();
        initListeners();
        initObjects();
    }

    private void initViews() {

        loginusername = (EditText) findViewById(R.id.loginusername);
        loginpassword = (EditText) findViewById(R.id.loginpassword);
        loginButton = (Button) findViewById(R.id.loginbutton);
        logintosignup = (Button) findViewById(R.id.logintosignup);

    }

    private void initListeners() {
        loginButton.setOnClickListener(this);
        logintosignup.setOnClickListener(this);
    }


    private void initObjects() {
        databaseHelper = new DatabaseHelper(activity);
        inputValidation = new InputValidation(activity);

    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.loginbutton:
                verifyFromSQLite();
                break;
            case R.id.logintosignup:
                // Navigate to RegisterActivity
                Intent intentRegister = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(intentRegister);
                break;
        }
    }

    private void verifyFromSQLite() {
        String usernametext = loginusername.getText().toString();
        String passwordtext = loginpassword.getText().toString();
        if (usernametext.equals("")) {
            errormsg = "Please Enter UserName";
            Toast.makeText(this, errormsg, Toast.LENGTH_SHORT).show();
            return;
        }
        else if (passwordtext.equals("")){
            errormsg = "Please Enter Password";
            Toast.makeText(this, errormsg, Toast.LENGTH_SHORT).show();
            return;
        }
        else if (databaseHelper.checkUser(usernametext
                , passwordtext)) {


            Intent accountsIntent = new Intent(activity, UserProfileActivity.class);
            startActivity(accountsIntent);


        }
        else {
            // Snack Bar to show success message that record is wrong
            errormsg = "Invalid Username or Password";
            Toast.makeText(this, errormsg, Toast.LENGTH_SHORT).show();
            return;
        }
    }
}
