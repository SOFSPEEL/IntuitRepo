package com.example.intuitrepos;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import java.util.List;

public class ReposViewModel extends ViewModel {
    private IRepository repository;
    private LiveData<List<Repo>> repos;

    public ReposViewModel(IRepository repository) {

        this.repository = repository;
        FetchRepos();
    }

    public void FetchRepos() {

        repos = repository.FetchRepos();
    }

    public LiveData<List<Repo>> getRepos() {
        return repos;
    }
}
