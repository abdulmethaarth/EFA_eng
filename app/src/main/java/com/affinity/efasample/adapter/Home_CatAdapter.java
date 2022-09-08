package com.affinity.efasample.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.affinity.efasample.R;
import com.affinity.efasample.activity.SubCategoryActivity;
import com.affinity.efasample.models.HomeCatlistDtls;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class Home_CatAdapter extends RecyclerView.Adapter<Home_CatAdapter.CustomViewHolder> {

    private List<HomeCatlistDtls> homeCatlistDtls;
    private AdapterView.OnItemClickListener listener;
    public Context context;
    public ArrayList<Home_CatAdapter> dataItems;


    public Home_CatAdapter(List<HomeCatlistDtls> homeCatlistDtls) {
        this.homeCatlistDtls = homeCatlistDtls;
    }

    @Override
    public Home_CatAdapter.CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cat_list_row, parent, false);

        return new Home_CatAdapter.CustomViewHolder(itView);
    }

    @Override
    public void onBindViewHolder(Home_CatAdapter.CustomViewHolder holder, int position) {
        HomeCatlistDtls data = homeCatlistDtls.get(position);
        Picasso.get().load(data.getImage()).into(holder.icon);
        holder.name.setText(data.getName());
    }

    @Override
    public int getItemCount() {
        return homeCatlistDtls.size();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        public CircleImageView icon;
        public LinearLayout header;
        TextView name;


        public CustomViewHolder(View itView) {
            super(itView);
            icon = (CircleImageView) itView.findViewById(R.id.image);
            header = (LinearLayout) itView.findViewById(R.id.header);
            name = (TextView) itView.findViewById(R.id.name);
        }
    }
}