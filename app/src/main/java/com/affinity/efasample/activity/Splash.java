package com.affinity.efasample.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import com.affinity.efasample.Constants;
import com.affinity.efasample.R;

public class Splash extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 2500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //getLocation();
                SharedPreferences prefs = getSharedPreferences(Constants.MY_PREFS_NAME, MODE_PRIVATE);
                if(prefs.getBoolean(Constants.KEY_OTP_LOGGED_IN, false)){
                    startActivity(new Intent(Splash.this, MainActivity.class));
                    finish();
                }
                else {
                    startActivity(new Intent(Splash.this,LangActivity.class));
                    finish();
                }
                /*startActivity(new Intent(Splash.this, LangActivity.class));
                finish();*/

            }
        },SPLASH_TIME_OUT);
    }
}