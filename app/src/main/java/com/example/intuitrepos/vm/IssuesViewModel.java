package com.example.intuitrepos.vm;

import com.example.intuitrepos.dto.Issue;
import com.example.intuitrepos.dto.Repo;
import com.example.intuitrepos.repository.IRepository;

public class IssuesViewModel extends ItemsViewModel<Issue> {

    private Repo repo;

    public IssuesViewModel(IRepository repository, Repo repo) {
        super(repository);
        this.repo = repo;
    }

    @Override
    public void fetch() {

        items = repository.fetchIssues(repo.id, repo.name, repo.openIssuesCount);
    }
}
