package com.example.intuitrepos.vm;

import android.arch.lifecycle.ViewModel;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.view.View;

import com.example.intuitrepos.dto.Repo;

public class RepoViewModel extends ViewModel {

    private Repo repo;

    public void setRepo(Repo repo){
        this.repo = repo;
    }

    public int getIssueVisibility() {
        return repo.openIssuesCount > 0 ? View.VISIBLE:View.GONE;
    }

    public String getName() {
        return repo.name;
    }

    public String getDescription() {
        return repo.description;
    }

    public Integer getOpenIssuesCount() {
        return repo.openIssuesCount;
    }

    public Integer getStargazersCount() {
        return repo.stargazersCount;
    }
}

