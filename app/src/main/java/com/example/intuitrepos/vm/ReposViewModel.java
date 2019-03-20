package com.example.intuitrepos.vm;

import com.example.intuitrepos.repository.IRepository;
import com.example.intuitrepos.dto.Repo;

public class ReposViewModel extends ItemsViewModel<Repo> {

    public ReposViewModel(IRepository repository) {
        super(repository);
    }

    @Override
    public void fetch() {

        items = repository.fetchRepos();
    }
}
