package com.example.intuitrepos.di;

import android.arch.lifecycle.ViewModelProvider;

import com.example.intuitrepos.views.LoginActivity;
import com.example.intuitrepos.views.ReposActivity;

import dagger.Component;

@Singleton2
@Component(modules = {ReposActivityModule.class}, dependencies = {AppComponent.class})

public interface ReposActivityComponent {
    void injectReposActivity(ReposActivity reposActivity);
    ViewModelProvider.Factory getFactory();
}
