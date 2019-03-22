package com.example.intuitrepos.di;

import android.arch.lifecycle.ViewModelProvider;

import com.example.intuitrepos.views.IssueDetailActivity;
import com.example.intuitrepos.views.RepoDetailActivity;

import dagger.Component;

@Singleton2
@Component(modules = {IssueDetailActivityModule.class}, dependencies = {AppComponent.class})

public interface IssueDetailActivityComponent extends IFactory {
    void injectReposActivity(IssueDetailActivity issueDetailActivity);
}
