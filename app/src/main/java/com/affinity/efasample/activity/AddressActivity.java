package com.affinity.efasample.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.affinity.efasample.R;

public class AddressActivity extends AppCompatActivity {

    RelativeLayout layout_back_arrow,layout_payment,layout_add_adress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address);

        layout_back_arrow = (RelativeLayout)findViewById(R.id.layout_back_arrow);
        layout_payment = (RelativeLayout)findViewById(R.id.layout_payment);
        layout_add_adress = (RelativeLayout)findViewById(R.id.layout_add_adress);

        layout_back_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AddressActivity.this,AddToCartActivity.class));
            }
        });

        layout_add_adress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* SharedPreferences.Editor editor = getSharedPreferences(Constants.MY_PREFS_NAME, MODE_PRIVATE).edit();
                editor.putString(Constants.pickupupLocation, "pickupupLocation");
                editor.apply();*/
                Intent placesSearch = new Intent(AddressActivity.this, MapActivity.class);
                startActivity(placesSearch);
            }
        });

        layout_payment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AddressActivity.this, MethodSelectionActivity.class));
            }
        });
    }
}