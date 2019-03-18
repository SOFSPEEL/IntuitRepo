package com.example.intuitrepos;

import dagger.Component;

@Component(modules = {MainActivityModule.class}, dependencies = {AppComponent.class})
public interface MainActivityComponent {
    void injectMainActivity(ReposActivity reposActivity);
}
