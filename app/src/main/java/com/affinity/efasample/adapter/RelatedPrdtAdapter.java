package com.affinity.efasample.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.recyclerview.widget.RecyclerView;

import com.affinity.efasample.R;
import com.affinity.efasample.activity.ProductDtlsActivity;

public class RelatedPrdtAdapter extends RecyclerView.Adapter<RelatedPrdtAdapter.CustomViewHolder> {
    Context context;

    private final int[] images;


    public RelatedPrdtAdapter(Context context, int[] images) {

        this.context = context;
        this.images = images;

    }

    @Override
    public RelatedPrdtAdapter.CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.related_prdt_layout, parent, false);

        return new RelatedPrdtAdapter.CustomViewHolder(itView);
    }

    @Override
    public void onBindViewHolder(RelatedPrdtAdapter.CustomViewHolder holder, int position) {
        holder.icon.setImageResource(images[position]);

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
        public LinearLayout header;


        public CustomViewHolder(View itView) {
            super(itView);
            icon = (ImageView) itView.findViewById(R.id.list_image);
            header = (LinearLayout) itView.findViewById(R.id.header);
        }
    }
}