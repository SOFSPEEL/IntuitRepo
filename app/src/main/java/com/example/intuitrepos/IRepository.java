package com.example.intuitrepos;

import java.util.List;

import retrofit2.Call;

public interface IRepository {
    Call<List<Repo>> FetchRepos();
}
