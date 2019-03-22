package com.example.intuitrepos.di;

import android.arch.lifecycle.ViewModelProvider;

import com.example.intuitrepos.views.RepoDetailActivity;

import dagger.Component;

@Singleton2
@Component(modules = {RepoDetailActivityModule.class}, dependencies = {AppComponent.class})

public interface RepoDetailActivityComponent extends IFactory{
    void injectReposActivity(RepoDetailActivity repoDetailActivity);

}
