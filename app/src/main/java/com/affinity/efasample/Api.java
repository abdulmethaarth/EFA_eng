package com.affinity.efasample;


import com.affinity.efasample.models.HomeCatList;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface Api {


   /* @FormUrlEncoded
    @POST("ac-logincrt.php")
    Call<BaseResponse> createProfile(@Field("email") String email,
                                       @Field("password") String password,
                                       @Field("username") String username,
                                       @Field("phone") String phone,
                                       @Field("university") String university,
                                       @Field("type") String type,
                                       @Field("batchname") String batchname
    );

    @POST("ac-login.php")
    @FormUrlEncoded
    Call<BaseResponse> getUser(@Field("email") String email,
                               @Field("password") String password);

    @POST("onlinetest/2021_api/ac-logincrt.php")
    Call<BaseResponse> regUser(@Body JsonObject jsonBody);

    @GET("sliderimg.php")
    Call<SliderList> getSliderList();*/


    @GET("category")
    Call<HomeCatList> getHomeCat(@Header("x-localization") String lang);

}
