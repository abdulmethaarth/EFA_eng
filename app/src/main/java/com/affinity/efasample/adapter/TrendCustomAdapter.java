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
import com.affinity.efasample.activity.ProductListActivity;

public class TrendCustomAdapter extends RecyclerView.Adapter<TrendCustomAdapter.CustomViewHolder> {
    Context context;

    private final int[] images;


    public TrendCustomAdapter(Context context, int[] images) {

        this.context = context;
        this.images = images;

    }

    @Override
    public TrendCustomAdapter.CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.trendlist_row, parent, false);

        return new TrendCustomAdapter.CustomViewHolder(itView);
    }

    @Override
    public void onBindViewHolder(TrendCustomAdapter.CustomViewHolder holder, int position) {
        holder.icon.setImageResource(images[position]);

        holder.header.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ProductListActivity.class);
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
        public LinearLayout header;


        public CustomViewHolder(View itView) {
            super(itView);
            icon = (ImageView) itView.findViewById(R.id.list_image);
            /*rate = (TextView) itView.findViewById(R.id.price);
            name = (TextView) itView.findViewById(R.id.name);*/
            header = (LinearLayout) itView.findViewById(R.id.header);
        }
    }
}