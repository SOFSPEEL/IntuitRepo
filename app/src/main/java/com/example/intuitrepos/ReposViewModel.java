package com.example.intuitrepos;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.os.Handler;

import java.util.List;
import java.util.logging.LogRecord;

public class ReposViewModel extends ViewModel {
    private IRepository repository;
    private LiveData<List<Repo>> repos;

    public ReposViewModel(IRepository repository) {

        this.repository = repository;
        FetchRepos();
        AddRepoAfterSomeTime(repository);
    }

    private void AddRepoAfterSomeTime(IRepository repository) {
        //todo: get rid off
        Repo repo = new Repo();
        repo.name = "junk";
        repo.description = "junkdesc";

        new Handler().postDelayed(() -> {

            repository.Insert(repo);
        }, 10000);
    }

    public void FetchRepos() {

        repos = repository.FetchRepos();
    }

    public LiveData<List<Repo>> getRepos() {
        return repos;
    }
}
