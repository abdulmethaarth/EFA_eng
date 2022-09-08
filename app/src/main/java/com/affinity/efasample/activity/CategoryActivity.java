package com.affinity.efasample.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.affinity.efasample.adapter.First_listCustomAdapter;
import com.affinity.efasample.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class CategoryActivity extends AppCompatActivity {


    //First_list
    int[] first_list_images = {R.drawable.accessories_box_img, R.drawable.perfume_box_img, R.drawable.soap_box_img, R.drawable.gardening_box_img,R.drawable.accessories_box_img,R.drawable.accessories_box_img,};
    String [] arabtname = {"إكسسوارات","العطور والبخور","صنع الصابون","مسار البستنة","إكسسوارات","إكسسوارات"};
    String [] catname = {"Accessories","Perfume and Incense","Soap Making","Gardening path","Accessories","Accessories"};
    RecyclerView first_listlView;
    First_listCustomAdapter first_listlAdapter;
    CircleImageView filter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);


        filter = (CircleImageView)findViewById(R.id.filter);
        first_listlView = (RecyclerView) findViewById(R.id.first_list);
        first_listlAdapter = new First_listCustomAdapter(CategoryActivity.this, first_list_images,arabtname,catname);
        LinearLayoutManager filayoutManager= new LinearLayoutManager(this,LinearLayoutManager.VERTICAL, false);
        first_listlView.setAdapter(first_listlAdapter);
        first_listlView.setLayoutManager(filayoutManager);
    }
}