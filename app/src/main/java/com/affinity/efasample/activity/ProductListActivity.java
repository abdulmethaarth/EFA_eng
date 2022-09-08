package com.affinity.efasample.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.affinity.efasample.adapter.CustomAdapter;
import com.affinity.efasample.R;

public class ProductListActivity extends AppCompatActivity {

    RelativeLayout layout_back_arrow;
    int[] images = {R.drawable.featured6, R.drawable.featured1, R.drawable.featured3, R.drawable.featured4, R.drawable.featured2, R.drawable.featured5, R.drawable.cat2, R.drawable.cat1, R.drawable.best_sell3,R.drawable.best_sell2,R.drawable.best_sell1};
    String [] rate = {"SAR 32","SAR 29","SAR 35","19","SAR 25","SAR 29","SAR 34","31","SAR 32","SAR 40","SAR 35"};
    String [] name = {"Men Shirt","Women T-Shirt","Women T-Shirt","Blezer","Women T-Shirt","Men T-Shirt","Men Shirt","Blezer","Women T-Shirt","Blezer","Women T-Shirt"};
    RecyclerView lView;
    CustomAdapter lAdapter;
    ImageView cart,loc,btm_home,btm_save,btm_notify,btm_account;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);

        btm_home = (ImageView)findViewById(R.id.btm_home);
        btm_save = (ImageView)findViewById(R.id.btm_save);
        btm_notify = (ImageView)findViewById(R.id.btm_notify);
        btm_account = (ImageView)findViewById(R.id.btm_account);
        btm_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ProductListActivity.this, MainActivity.class));
                finish();
            }
        });

        btm_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ProductListActivity.this, ProductListActivity.class));
                finish();
            }
        });

        btm_notify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ProductListActivity.this, NotificationActivity.class));
                finish();
            }
        });

        btm_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ProductListActivity.this, ProfileActivity.class));
                finish();
            }
        });

        layout_back_arrow = (RelativeLayout)findViewById(R.id.layout_back_arrow);
        lView = (RecyclerView) findViewById(R.id.lists);
        lAdapter = new CustomAdapter(ProductListActivity.this, images,rate,name);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(),2);
        gridLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        lView.setAdapter(lAdapter);
        lView.setLayoutManager(gridLayoutManager);

        layout_back_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ProductListActivity.this,MainActivity.class));
            }
        });
    }

}