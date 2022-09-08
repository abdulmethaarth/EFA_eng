package com.affinity.efasample.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.affinity.efasample.R;

public class LoginOption extends AppCompatActivity {

    RelativeLayout layout_login;
    TextView txt_signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_option);

        layout_login = (RelativeLayout)findViewById(R.id.layout_login);
        txt_signup = (TextView) findViewById(R.id.txt_signup);

        layout_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginOption.this, LoginMobileActivity.class));
                finish();
            }
        });

        txt_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginOption.this, SignupActivity.class));
                finish();
            }
        });


    }
}