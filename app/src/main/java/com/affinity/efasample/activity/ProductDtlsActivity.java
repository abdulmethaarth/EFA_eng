package com.affinity.efasample.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.affinity.efasample.R;
import com.affinity.efasample.adapter.RelatedPrdtAdapter;

public class ProductDtlsActivity extends AppCompatActivity {

    RelativeLayout layout_back_arrow;
    TextView offerline,addCart,buyNow,s,m,l,xl;

    //Best sell
    int[] best_images = {R.drawable.dtls_img, R.drawable.featured6, R.drawable.best_sell3, R.drawable.featured4};
    RecyclerView Best_lView;
    RelatedPrdtAdapter Best_lAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_dtls);


        Best_lView = (RecyclerView) findViewById(R.id.related_product);
        Best_lAdapter = new RelatedPrdtAdapter(ProductDtlsActivity.this, best_images);
        LinearLayoutManager layoutManagers= new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false);
        Best_lView.setAdapter(Best_lAdapter);
        Best_lView.setLayoutManager(layoutManagers);


        layout_back_arrow = (RelativeLayout)findViewById(R.id.layout_back_arrow);
        addCart = (TextView) findViewById(R.id.addCart);
        buyNow = (TextView) findViewById(R.id.buyNow);

        s = (TextView) findViewById(R.id.s);
        m = (TextView) findViewById(R.id.m);
        l = (TextView) findViewById(R.id.l);
        xl = (TextView) findViewById(R.id.xl);


        offerline = (TextView) findViewById(R.id.offerline);
        offerline.setPaintFlags(offerline.getPaintFlags() & (~Paint.STRIKE_THRU_TEXT_FLAG));


        layout_back_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ProductDtlsActivity.this,ProductListActivity.class));
            }
        });

        addCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ProductDtlsActivity.this, AddToCartActivity.class));
            }
        });

        buyNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ProductDtlsActivity.this,AddToCartActivity.class));
            }
        });

        s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s.setBackground(getResources().getDrawable(R.drawable.size_btn_box));
                s.setTextColor(getResources().getColor(R.color.white));

                m.setBackground(getResources().getDrawable(R.drawable.size_btn_box_border));
                m.setTextColor(getResources().getColor(R.color.purple_700));

                l.setBackground(getResources().getDrawable(R.drawable.size_btn_box_border));
                l.setTextColor(getResources().getColor(R.color.purple_700));

                xl.setBackground(getResources().getDrawable(R.drawable.size_btn_box_border));
                xl.setTextColor(getResources().getColor(R.color.purple_700));
            }
        });

        m.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                m.setBackground(getResources().getDrawable(R.drawable.size_btn_box));
                m.setTextColor(getResources().getColor(R.color.white));

                s.setBackground(getResources().getDrawable(R.drawable.size_btn_box_border));
                s.setTextColor(getResources().getColor(R.color.purple_700));

                l.setBackground(getResources().getDrawable(R.drawable.size_btn_box_border));
                l.setTextColor(getResources().getColor(R.color.purple_700));

                xl.setBackground(getResources().getDrawable(R.drawable.size_btn_box_border));
                xl.setTextColor(getResources().getColor(R.color.purple_700));
            }
        });

        l.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                m.setBackground(getResources().getDrawable(R.drawable.size_btn_box_border));
                m.setTextColor(getResources().getColor(R.color.purple_700));

                s.setBackground(getResources().getDrawable(R.drawable.size_btn_box_border));
                s.setTextColor(getResources().getColor(R.color.purple_700));

                l.setBackground(getResources().getDrawable(R.drawable.size_btn_box));
                l.setTextColor(getResources().getColor(R.color.white));

                xl.setBackground(getResources().getDrawable(R.drawable.size_btn_box_border));
                xl.setTextColor(getResources().getColor(R.color.purple_700));
            }
        });

        xl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                m.setBackground(getResources().getDrawable(R.drawable.size_btn_box_border));
                m.setTextColor(getResources().getColor(R.color.purple_700));

                s.setBackground(getResources().getDrawable(R.drawable.size_btn_box_border));
                s.setTextColor(getResources().getColor(R.color.purple_700));

                l.setBackground(getResources().getDrawable(R.drawable.size_btn_box_border));
                l.setTextColor(getResources().getColor(R.color.purple_700));

                xl.setBackground(getResources().getDrawable(R.drawable.size_btn_box));
                xl.setTextColor(getResources().getColor(R.color.white));
            }
        });


    }

}