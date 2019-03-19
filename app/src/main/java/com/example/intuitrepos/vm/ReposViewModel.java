package com.example.intuitrepos.vm;

import android.arch.lifecycle.LiveData;
import android.os.Handler;

import com.example.intuitrepos.repository.IRepository;
import com.example.intuitrepos.dto.Repo;

import java.util.List;

public class ReposViewModel extends BaseViewModel {
    private IRepository repository;
    private LiveData<List<Repo>> repos;

    public ReposViewModel(IRepository repository) {

        this.repository = repository;
        fetch();
        addRepoAfterSomeTime(repository);
    }

    private void addRepoAfterSomeTime(IRepository repository) {
        //todo: get rid off
        Repo repo = new Repo();
        repo.name = "junk";
        repo.description = "junkdesc";

        new Handler().postDelayed(() -> {

            repository.insert(repo);
        }, 10000);
    }

    @Override
    public void fetch() {

        repos = repository.fetchRepos();
    }

    public LiveData<List<Repo>> getRepos() {
        return repos;
    }
}
