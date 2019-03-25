package com.example.intuitrepos.di;

import com.example.intuitrepos.views.screens.IssueDetailActivity;

import dagger.Component;

@Singleton2
@Component(modules = {IssueDetailActivityModule.class}, dependencies = {AppComponent.class})

public interface IssueDetailActivityComponent extends IFactory {
    void injectReposActivity(IssueDetailActivity issueDetailActivity);
}
