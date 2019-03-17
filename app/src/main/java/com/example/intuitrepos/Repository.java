package com.example.intuitrepos;

import java.util.List;

import retrofit2.Call;

public class Repository implements IRepository {

    private RepoService repoService;

    public Repository(RepoService repoService) {

        this.repoService = repoService;
    }

    @Override
    public Call<List<Repo>> FetchRepos() {
        return repoService.GetRepos();
    }
}
