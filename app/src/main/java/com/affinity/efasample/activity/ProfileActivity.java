package com.affinity.efasample.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.affinity.efasample.R;

public class ProfileActivity extends AppCompatActivity {

    TextView btn_logout;
    ImageView back,notify;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        back = (ImageView)findViewById(R.id.back);
        notify = (ImageView)findViewById(R.id.notify);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ProfileActivity.this, MainActivity.class));
                finish();
            }
        });

        notify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ProfileActivity.this, NotificationActivity.class));
                finish();
            }
        });

        btn_logout = (TextView)findViewById(R.id.btn_logout);
        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(ProfileActivity.this);
                alertDialogBuilder.setTitle("Logout");
                alertDialogBuilder.setMessage("Are you sure you want to logout");
                alertDialogBuilder.setPositiveButton("Ok",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface arg0, int arg1) {
                                startActivity(new Intent(ProfileActivity.this, Splash.class));
                                finish();

                            }
                        });

                alertDialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();
                        /*Intent logout = new Intent(getApplicationContext(), AboutActivity.class);
                        startActivity(logout);*/
            }
        });
    }
}