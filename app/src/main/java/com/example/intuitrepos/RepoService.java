package com.example.intuitrepos;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RepoService {

    @GET("/users/intuit/repos")
    Call<List<Repo>> GetRepos();
}
