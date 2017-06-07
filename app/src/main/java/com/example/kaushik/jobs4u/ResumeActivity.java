package com.example.kaushik.jobs4u;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Kaushik on 6/5/2017.
 */

public class ResumeActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resume_main);

        TextView addresume = (TextView) findViewById(R.id.addresume);
        addresume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent loginIntent = new Intent(ResumeActivity.this, Resume_form.class);
                startActivity(loginIntent);
            }
        });
    }
}
