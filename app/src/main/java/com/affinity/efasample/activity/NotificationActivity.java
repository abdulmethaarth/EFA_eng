package com.affinity.efasample.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.affinity.efasample.R;

public class NotificationActivity extends AppCompatActivity {

    ImageView cart,loc,btm_home,btm_save,btm_notify,btm_account;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        cart = (ImageView)findViewById(R.id.cart);
        btm_home = (ImageView)findViewById(R.id.btm_home);
        btm_save = (ImageView)findViewById(R.id.btm_save);
        btm_notify = (ImageView)findViewById(R.id.btm_notify);
        btm_account = (ImageView)findViewById(R.id.btm_account);

        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(NotificationActivity.this, AddToCartActivity.class));
                finish();
            }
        });

        btm_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(NotificationActivity.this, MainActivity.class));
                finish();
            }
        });

        btm_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(NotificationActivity.this, ProductListActivity.class));
                finish();
            }
        });

        btm_notify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(NotificationActivity.this, NotificationActivity.class));
                finish();
            }
        });

        btm_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(NotificationActivity.this, ProfileActivity.class));
                finish();
            }
        });
    }
}