package com.example.intuitrepos.di;

import com.example.intuitrepos.repository.IRepository;

import javax.inject.Inject;

import okhttp3.Credentials;

public class CredentialsHolder {

    private IRepository repository;

    @Inject
    public CredentialsHolder(IRepository repository) {
        this.repository = repository;
    }

    public String get() {
        return Credentials.basic("sofspeel", repository.fetchPassword());
    }

}
