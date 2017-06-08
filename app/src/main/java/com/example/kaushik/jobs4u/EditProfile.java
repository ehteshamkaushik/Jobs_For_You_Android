package com.example.kaushik.jobs4u;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kaushik on 6/8/2017.
 */

public class EditProfile extends AppCompatActivity{
        String usernametext;
        TextView username, password;
    EditText email, address, mobile;
        User user;
        DatabaseHelper databaseHelper;
        List<User> userList = new ArrayList<>();
    Button changepw, savechanges;
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.edit_profile);
            final Intent intent = getIntent();
            usernametext = intent.getStringExtra("username");
            initViews();
            initObjects();
            show();


            changepw.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final Dialog dialog = new Dialog(v.getContext());
                    dialog.setContentView(R.layout.change_password);
                    dialog.setTitle("Change Password");

                    final EditText oldpw = (EditText) dialog.findViewById(R.id.oldpw);
                    final EditText newpw = (EditText) dialog.findViewById(R.id.newpw);
                    final EditText confirmpw = (EditText) dialog.findViewById(R.id.confirmpw);

                    Button change = (Button) dialog.findViewById(R.id.pw);
                    change.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if(!oldpw.getText().toString().equals(user.getPassword()))
                            {
                                Toast.makeText(v.getContext(), "Wrong Old Password", Toast.LENGTH_LONG).show();
                            }
                            else if (newpw.getText().toString().equals(""))
                            {
                                Toast.makeText(v.getContext(), "Please Enter New Password", Toast.LENGTH_LONG).show();
                            }
                            else if (confirmpw.getText().toString().equals(""))
                            {
                                Toast.makeText(v.getContext(), "Please Confirm New Password", Toast.LENGTH_LONG).show();
                            }
                            else if (!newpw.getText().toString().equals(confirmpw.getText().toString()))
                            {
                                Toast.makeText(v.getContext(), "Please Confirm New Password", Toast.LENGTH_LONG).show();
                            }
                            else
                            {
                                user.setPassword(newpw.getText().toString());
                                String str = "" ;
                                for (int i = 0; i < newpw.getText().toString().length(); i++)
                                    str+='*';
                                password.setText(str);
                                dialog.dismiss();
                            }
                        }
                    });
                    dialog.show();
                    Window window = dialog.getWindow();
                    window.setLayout(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT);
                }
            });

            savechanges.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    saveProfile();
                }
            });
        }

    private void saveProfile() {
        if (password.getText().toString().equals(""))
        {
            Toast.makeText(this, "Please Enter Password", Toast.LENGTH_LONG).show();
            return;
        }
        else
        {
            user.setAddress(address.getText().toString());
            user.setEmail(email.getText().toString());
            user.setMobile(mobile.getText().toString());

            databaseHelper.deleteUser(user);
            databaseHelper.addUser(user);
            return;
        }
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
        changepw = (Button) findViewById(R.id.changepw);

    }

        private void initObjects() {
            user = new User();
            databaseHelper = new DatabaseHelper(EditProfile.this);
        }

        private void initViews() {
            username = (TextView) findViewById(R.id.edit_username);
            password = (TextView) findViewById(R.id.edit_password);
            address = (EditText) findViewById(R.id.edit_adddress);
            mobile = (EditText) findViewById(R.id.edit_mobile);
            email = (EditText) findViewById(R.id.edit_email);
            savechanges = (Button) findViewById(R.id.saveprofilechanges);

        }
    }