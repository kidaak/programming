package com.bkstorm.retrofit.service;

import com.bkstorm.retrofit.model.User;

/**
 * Created by hoangnv on 29/08/2015.
 */
public class LoginServiceTest {
    public static void main(String[] args){
        String username = "hoangnv28";
        String password = "123456a@";
        LoginService loginService = ServiceGenerator.createService(LoginService.class, LoginService.BASE_URL, username, password);
        User user = loginService.basicLogin();
    }
}
