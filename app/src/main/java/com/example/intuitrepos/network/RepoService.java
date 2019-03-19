package com.example.intuitrepos.network;

import com.example.intuitrepos.dto.Repo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RepoService {

    @GET("/users/intuit/repos")
    Call<List<Repo>> getRepos();
}
