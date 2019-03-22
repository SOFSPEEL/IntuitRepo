package com.example.intuitrepos.di;

import android.support.annotation.Nullable;

import com.example.intuitrepos.repository.IRepository;

public
class RepositoryHolder {


    private IRepository repository;

    @Nullable
    IRepository getRepository() {
        return repository;
    }

    void setRepository(IRepository repository) {
        this.repository = repository;

    }

}
