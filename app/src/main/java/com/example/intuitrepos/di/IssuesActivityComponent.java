package com.example.intuitrepos.di;

import android.arch.lifecycle.ViewModelProvider;

import com.example.intuitrepos.views.IssuesActivity;
import com.example.intuitrepos.views.ReposActivity;

import dagger.Component;

@Singleton2
@Component(modules = {IssuesActivityModule.class}, dependencies = {AppComponent.class})

public interface IssuesActivityComponent extends IFactory {
    void injectReposActivity(IssuesActivity activity);
}
