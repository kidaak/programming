package com.bkstorm.retrofit.service;

import java.util.List;
import static com.bkstorm.retrofit.service.GitHubClient.*;

/**
 * Created by hoangnv on 29/08/2015.
 */
public class GitHubClientTest {
    public static void main(String... args) {
        String API_URL = "https://developer.github.com/v3/";

        // Create a very simple REST adapter which points the GitHub API endpoint.
        GitHubClient client = ServiceGenerator.createService(GitHubClient.class, API_URL);

        // Fetch and print a list of the contributors to this library.
        List<Contributor> contributors = client.contributors("fs_opensource", "android-boilerplate");
        for (Contributor contributor : contributors) {
            System.out.println(contributor.login + " (" + contributor.contributions + ")");
        }
    }
}
