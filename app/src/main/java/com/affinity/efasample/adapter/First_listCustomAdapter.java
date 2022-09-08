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

public class First_listCustomAdapter extends RecyclerView.Adapter<First_listCustomAdapter.CustomViewHolder> {
    Context context;

    private final int[] images;
    private final String [] arabtname;
    private final String [] catname;


    public First_listCustomAdapter(Context context, int[] images,String [] arabtname,String [] catname) {

        this.context = context;
        this.images = images;
        this.arabtname = arabtname;
        this.catname = catname;

    }

    @Override
    public First_listCustomAdapter.CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.firstlist_row, parent, false);

        return new First_listCustomAdapter.CustomViewHolder(itView);
    }

    @Override
    public void onBindViewHolder(First_listCustomAdapter.CustomViewHolder holder, int position) {
        holder.icon.setImageResource(images[position]);
        holder.arab_name.setText(arabtname[position]);
        holder.name.setText(catname[position]);
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
        public LinearLayout header;
        TextView name,arab_name;


        public CustomViewHolder(View itView) {
            super(itView);
            icon = (ImageView) itView.findViewById(R.id.image);
            header = (LinearLayout) itView.findViewById(R.id.header);
            name = (TextView) itView.findViewById(R.id.name);
            arab_name = (TextView) itView.findViewById(R.id.arab);


        }
    }
}