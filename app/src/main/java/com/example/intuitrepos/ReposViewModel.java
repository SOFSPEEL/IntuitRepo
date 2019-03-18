package com.example.intuitrepos;

import android.arch.lifecycle.ViewModel;

import java.util.List;

import retrofit2.Call;

public class ReposViewModel extends ViewModel {
    private IRepository repository;

    public ReposViewModel(IRepository repository) {

        this.repository = repository;
    }

    public Call<List<Repo>> FetchRepos() {
        return repository.FetchRepos();
    }
}
