package com.example.intuitrepos.network;

import com.example.intuitrepos.dto.Issue;
import com.example.intuitrepos.dto.Repo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RepoService {

    @GET("/users/intuit/repos")
    Call<List<Repo>> getRepos();

    @GET("/repos/intuit/{repoName}/issues/{number}")
    Call<Issue> getIssue(@Path("repoName") String repoName, @Path("number") int number);
}
