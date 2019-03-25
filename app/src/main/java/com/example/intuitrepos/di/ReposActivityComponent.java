package com.example.intuitrepos.di;

import com.example.intuitrepos.views.screens.ReposActivity;

import dagger.Component;

@Singleton2
@Component(modules = {ReposActivityModule.class}, dependencies = {AppComponent.class})

public interface ReposActivityComponent extends IFactory{
    void injectReposActivity(ReposActivity reposActivity);

}
