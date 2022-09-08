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
import com.affinity.efasample.activity.CategoryActivity;

public class Home_BannerAdapter extends RecyclerView.Adapter<Home_BannerAdapter.CustomViewHolder> {
    Context context;

    private final int[] images;


    public Home_BannerAdapter(Context context, int[] images) {

        this.context = context;
        this.images = images;

    }

    @Override
    public Home_BannerAdapter.CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.banner_list, parent, false);

        return new Home_BannerAdapter.CustomViewHolder(itView);
    }

    @Override
    public void onBindViewHolder(Home_BannerAdapter.CustomViewHolder holder, int position) {
        holder.icon.setImageResource(images[position]);
        holder.header.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, CategoryActivity.class);
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
        public LinearLayout header;
        TextView name;


        public CustomViewHolder(View itView) {
            super(itView);
            icon = (ImageView) itView.findViewById(R.id.image);
            header = (LinearLayout) itView.findViewById(R.id.header);



        }
    }
}