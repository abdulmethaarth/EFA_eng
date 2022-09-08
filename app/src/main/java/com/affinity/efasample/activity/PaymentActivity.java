package com.affinity.efasample.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.affinity.efasample.R;

public class PaymentActivity extends AppCompatActivity {

    RelativeLayout layout_back_arrow,layout_checkout,layout_add_card;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        layout_back_arrow = (RelativeLayout)findViewById(R.id.layout_back_arrow);
        layout_checkout = (RelativeLayout)findViewById(R.id.layout_Checkout);
        layout_add_card = (RelativeLayout)findViewById(R.id.layout_add_card);

        layout_back_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PaymentActivity.this, MethodSelectionActivity.class));
            }
        });

        layout_add_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(PaymentActivity.this, "Coming soon", Toast.LENGTH_SHORT).show();
            }
        });

        layout_checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PaymentActivity.this, BuyNowActivity.class));
            }
        });
    }
}