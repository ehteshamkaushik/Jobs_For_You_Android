package com.example.kaushik.jobs4u;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Kaushik on 6/5/2017.
 */

public class AddResumeActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_resume);
    }
    public void showDatePickerDialog(android.view.View v) {
        DatePickerFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }
}
