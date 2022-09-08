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
import com.affinity.efasample.activity.InnerSubCategoryActivity;

public class SubCatAdapter extends RecyclerView.Adapter<SubCatAdapter.CustomViewHolder> {
    Context context;

    private final int[] images;
    private final String[] rate;
    private final String[] name;

    public SubCatAdapter(Context context, int[] images, String[] rate, String[] name) {

        this.context = context;
        this.images = images;
        this.rate = rate;
        this.name = name;
    }

    @Override
    public SubCatAdapter.CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.sub_cat_list_row, parent, false);

        return new SubCatAdapter.CustomViewHolder(itView);
    }

    @Override
    public void onBindViewHolder(SubCatAdapter.CustomViewHolder holder, int position) {
        holder.icon.setImageResource(images[position]);
        holder.rate.setText(rate[position]);
        holder.name.setText(name[position]);
        holder.header.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, InnerSubCategoryActivity.class);
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
        public LinearLayout header;


        public CustomViewHolder(View itView) {
            super(itView);
            icon = (ImageView) itView.findViewById(R.id.list_image);
            rate = (TextView) itView.findViewById(R.id.price);
            name = (TextView) itView.findViewById(R.id.name);
            header = (LinearLayout) itView.findViewById(R.id.header);
        }
    }
}