package com.affinity.efasample.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.affinity.efasample.R;
import com.affinity.efasample.activity.ProductDtlsActivity;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CustomViewHolder> {
    Context context;

    private final int[] images;
    private final String[] rate;
    private final String[] name;
    private final String[] brand;

    public CartAdapter(Context context, int[] images, String[] rate, String[] name, String[] brand) {

        this.context = context;
        this.images = images;
        this.rate = rate;
        this.name = name;
        this.brand = brand;
    }

    @Override
    public CartAdapter.CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cartlist_row, parent, false);

        return new CartAdapter.CustomViewHolder(itView);
    }

    @Override
    public void onBindViewHolder(CartAdapter.CustomViewHolder holder, int position) {
        holder.icon.setImageResource(images[position]);
        holder.rate.setText(rate[position]);
        holder.name.setText(name[position]);
        holder.brand.setText(brand[position]);
        holder.header.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ProductDtlsActivity.class);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return images.length;

    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        public ImageView icon;
        public TextView rate;
        public TextView name;
        public TextView brand;
        public LinearLayout header;


        public CustomViewHolder(View itView) {
            super(itView);
            icon = (ImageView) itView.findViewById(R.id.list_image);
            rate = (TextView) itView.findViewById(R.id.price);
            name = (TextView) itView.findViewById(R.id.name);
            brand = (TextView) itView.findViewById(R.id.brand);
            header = (LinearLayout) itView.findViewById(R.id.header);

        }
    }
}