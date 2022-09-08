package com.affinity.efasample.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.affinity.efasample.Constants;
import com.affinity.efasample.R;

public class LangActivity extends AppCompatActivity {

    TextView english,arab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lang);

        english = (TextView)findViewById(R.id.english);
        arab = (TextView)findViewById(R.id.arab);

        english.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = getSharedPreferences(Constants.MY_PREFS_NAME, MODE_PRIVATE).edit();
                editor.putString(Constants.language,"en" );
                editor.apply();
                Intent intent = new Intent(LangActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        arab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = getSharedPreferences(Constants.MY_PREFS_NAME, MODE_PRIVATE).edit();
                editor.putString(Constants.language,"ar" );
                editor.apply();
                Intent intent = new Intent(LangActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

    }
}