package com.affinity.efasample.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.affinity.efasample.R;

public class SignupActivity extends AppCompatActivity {

    RelativeLayout layout_signin ,layout_signup,layout_back_arrow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        layout_signin = (RelativeLayout)findViewById(R.id.layout_signin);
        layout_signup = (RelativeLayout)findViewById(R.id.layout_signup);
        layout_back_arrow = (RelativeLayout)findViewById(R.id.layout_back_arrow);

        layout_signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignupActivity.this, LoginActivity.class));
            }
        });

        layout_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignupActivity.this,LoginActivity.class));
            }
        });

        layout_back_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignupActivity.this, LoginOption.class));
            }
        });
    }
}