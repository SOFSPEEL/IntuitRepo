package com.example.intuitrepos.di;

import com.example.intuitrepos.views.screens.IssuesActivity;

import dagger.Component;

@ActivityScope
@Component(modules = {IssuesActivityModule.class}, dependencies = {AppComponent.class})

public interface IssuesActivityComponent extends IFactory {
    void injectReposActivity(IssuesActivity activity);
}
