package com.example.intuitrepos.di;

import com.example.intuitrepos.views.ReposActivity;

import dagger.Component;

@Component(modules = {MainActivityModule.class}, dependencies = {AppComponent.class})
public interface MainActivityComponent {
    void injectMainActivity(ReposActivity reposActivity);
}
