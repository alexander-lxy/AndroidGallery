package com.alee.androidgallery.apiservice;

import com.alee.androidgallery.entity.User;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiService {

    @POST("/api/login")
    Call<User> login(
            @Query("username") String username,
            @Query("password") String password
    );

    @GET("/api/register")
    Call<User> register(
            @Query("username") String username,
            @Query("password") String password,
            @Query("password") String email
    );
}
