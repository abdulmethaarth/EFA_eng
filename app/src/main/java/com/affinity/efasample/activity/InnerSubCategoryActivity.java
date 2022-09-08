package com.affinity.efasample.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.affinity.efasample.adapter.InnerSubCatAdapter;
import com.affinity.efasample.R;

public class InnerSubCategoryActivity extends AppCompatActivity {

    ImageView back;
    int[] images = {R.drawable.accessories_box_img, R.drawable.banner3, R.drawable.banner2, R.drawable.banner,R.drawable.accessories_box_img, R.drawable.banner3, R.drawable.banner2, R.drawable.banner};
    String [] rate = {"SAR 32.00","SAR 29.00","SAR 34.00","SAR 31.00","SAR 32.00","SAR 29.00","SAR 34.00","SAR 31.00"};
    String [] name = {"Polo Blue By Ralph","Lacoste Eau De Blanc","Bvlgari Man In Black","Mont Blanc Legend Night","Seductive Homme Eau","Jaguar Men Classic","Dolce & Gabbana","Others"};
    RecyclerView lView;
    String [] count = {"Available : 15","Available : 10","Available : 5","Available : 27","Available : 45","Available : 50","Available : 30","Available : 23" };
    InnerSubCatAdapter lAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inner_sub_category);

        lView = (RecyclerView) findViewById(R.id.first_listcat);
        back = (ImageView) findViewById(R.id.back);
        lAdapter = new InnerSubCatAdapter(InnerSubCategoryActivity.this, images,rate,name,count);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(),2);
        gridLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        lView.setAdapter(lAdapter);
        lView.setLayoutManager(gridLayoutManager);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(InnerSubCategoryActivity.this, SubCategoryActivity.class));
            }
        });

    }
}