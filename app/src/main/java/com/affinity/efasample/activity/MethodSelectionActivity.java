package com.affinity.efasample.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.affinity.efasample.R;

public class MethodSelectionActivity extends AppCompatActivity {

    ImageView myself,card,cod;
    RelativeLayout layout_continue,layout_back_arrow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_method_selection);

        myself = (ImageView)findViewById(R.id.myself);
        card = (ImageView)findViewById(R.id.card);
        cod = (ImageView)findViewById(R.id.cod);

        layout_continue = (RelativeLayout) findViewById(R.id.layout_continue);
        layout_back_arrow = (RelativeLayout)findViewById(R.id.layout_back_arrow);

        layout_back_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MethodSelectionActivity.this, AddressActivity.class));
            }
        });

        layout_continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MethodSelectionActivity.this, PaymentActivity.class));
            }
        });

        cod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cod.setBackgroundResource(R.drawable.tick_img);
                card.setBackgroundResource(R.drawable.radio_btn_circle);
                myself.setBackgroundResource(R.drawable.radio_btn_circle);
            }
        });

        card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cod.setBackgroundResource(R.drawable.radio_btn_circle);
                card.setBackgroundResource(R.drawable.tick_img);
                myself.setBackgroundResource(R.drawable.radio_btn_circle);
            }
        });

        myself.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cod.setBackgroundResource(R.drawable.radio_btn_circle);
                card.setBackgroundResource(R.drawable.radio_btn_circle);
                myself.setBackgroundResource(R.drawable.tick_img);
            }
        });

    }
}