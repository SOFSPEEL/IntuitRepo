package com.example.intuitrepos.di;

import com.example.intuitrepos.views.screens.RepoDetailActivity;

import dagger.Component;

@ActivityScope
@Component(modules = {RepoDetailActivityModule.class}, dependencies = {AppComponent.class})

public interface RepoDetailActivityComponent extends IFactory{
    void injectReposActivity(RepoDetailActivity repoDetailActivity);

}
