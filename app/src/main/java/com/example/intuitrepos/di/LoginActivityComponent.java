package com.example.intuitrepos.di;

import com.example.intuitrepos.views.screens.LoginActivity;

import dagger.Component;

@ActivityScope
@Component(modules = {LoginActivityModule.class}, dependencies = {AppComponent.class})

public interface LoginActivityComponent extends IFactory {
    void injectLoginActivity(LoginActivity loginActivity);
}
