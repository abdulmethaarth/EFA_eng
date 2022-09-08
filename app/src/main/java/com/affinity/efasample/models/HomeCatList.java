package com.affinity.efasample.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class HomeCatList extends BaseResponse{

    @SerializedName("data")
    @Expose
    private ArrayList<HomeCatlistDtls> homeCatlistDtls;

    public ArrayList<HomeCatlistDtls> getHomeCatlistDtls() {
        return homeCatlistDtls;
    }

    public void setHomeCatlistDtls(ArrayList<HomeCatlistDtls> homeCatlistDtls) {
        this.homeCatlistDtls = homeCatlistDtls;
    }
}
