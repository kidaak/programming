package com.bkstorm.retrofit.service;

import com.bkstorm.retrofit.model.User;

import retrofit.http.POST;

/**
 * Created by hoangnv on 29/08/2015.
 */
public interface LoginService {
    public static final String BASE_URL = "https://api.yourdomain.com";

    @POST("/login")
    public User basicLogin();
}
