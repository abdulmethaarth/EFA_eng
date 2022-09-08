package com.affinity.efasample.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.affinity.efasample.R;
import com.affinity.efasample.adapter.SubCatAdapter;

public class SubCategoryActivity extends AppCompatActivity {

    //Featured
    ImageView back;
    int[] images = {R.drawable.accessories_box_img, R.drawable.banner3, R.drawable.banner2, R.drawable.banner,R.drawable.accessories_box_img, R.drawable.banner3, R.drawable.banner2, R.drawable.banner};
    String [] rate = {"SAR 32.00","SAR 29.00","SAR 34.00","SAR 31.00","SAR 32.00","SAR 29.00","SAR 34.00","SAR 31.00"};
    String [] name = {"Oud and incense","Men's perfumes","Women's perfumes","Children's perfumes","Home perfumes","Car fresheners","Hair and body\nperfumes","Others"};
    RecyclerView lView;
    SubCatAdapter lAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_category);

        lView = (RecyclerView) findViewById(R.id.first_listcat);
        back = (ImageView) findViewById(R.id.back);
        lAdapter = new SubCatAdapter(SubCategoryActivity.this, images,rate,name);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(),2);
        gridLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        lView.setAdapter(lAdapter);
        lView.setLayoutManager(gridLayoutManager);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SubCategoryActivity.this,MainActivity.class));
            }
        });
    }
}