package com.example.intuitrepos.vm;

import android.arch.lifecycle.ViewModel;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.view.View;

import com.example.intuitrepos.dto.Repo;

public class RepoViewModel extends BaseObservable {

    private final Repo repo;

    public RepoViewModel(Repo repo) {
        this.repo = repo;
    }

    @Bindable
    public int getIssueVisibility() {
        return repo.openIssuesCount > 0 ? View.VISIBLE:View.GONE;
    }

    @Bindable
    public String getName() {
        return repo.name;
    }

    @Bindable
    public String getDescription() {
        return repo.description;
    }

    @Bindable
    public Integer getOpenIssuesCount() {
        return repo.openIssuesCount;
    }

    @Bindable
    public Integer getStargazersCount() {
        return repo.stargazersCount;
    }
}

