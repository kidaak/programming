package com.bkstorm.retrofit.service;

import com.bkstorm.retrofit.model.Contributor;

import java.util.List;

import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by hoangnv on 29/08/2015.
 */
public interface GitHubClient {
    @GET("/repos/{owner}/{repo}/contributors")
    List<Contributor> contributors(
            @Path("owner") String owner,
            @Path("repo") String repo
    );
}
