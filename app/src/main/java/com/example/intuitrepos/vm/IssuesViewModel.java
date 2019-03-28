package com.example.intuitrepos.vm;

import android.arch.lifecycle.LiveData;

import com.example.intuitrepos.dto.Issue;
import com.example.intuitrepos.dto.Repo;
import com.example.intuitrepos.repository.IRepository;

import java.util.List;

public class IssuesViewModel extends ItemsViewModel<Issue> {

    private Repo repo;

    public IssuesViewModel(IRepository repository) {
        super(repository);
    }

    @Override
    public LiveData<String> getError() {
        return repository.getIssuesError();
    }

    @Override
    public void fetch() {

        repository.fetchIssues(repo.id, repo.name, repo.openIssuesCount);
    }

    @Override
    public LiveData<List<Issue>> getItems() {
        return repository.getIssues(repo.id);
    }

    public void setRepo(Repo repo) {
        this.repo = repo;
    }
}
