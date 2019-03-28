package com.example.intuitrepos.vm;

import android.arch.lifecycle.LiveData;

import com.example.intuitrepos.repository.IRepository;
import com.example.intuitrepos.dto.Repo;

import java.util.List;

public class ReposViewModel extends ItemsViewModel<Repo> {

    public ReposViewModel(IRepository repository) {
        super(repository);
    }

    @Override
    public LiveData<String> getError() {
        return repository.getReposError();
    }

    @Override
    public void fetch() {

        repository.fetchRepos();
    }

    @Override
    public LiveData<List<Repo>> getItems() {
        return repository.getRepos();
    }
}
