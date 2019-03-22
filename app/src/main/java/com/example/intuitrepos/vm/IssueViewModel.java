package com.example.intuitrepos.vm;

import android.arch.lifecycle.ViewModel;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.view.View;

import com.example.intuitrepos.dto.Issue;

public class IssueViewModel extends ViewModel {

    private Issue issue;


    public String getTitle() {
        return issue.title;
    }

    public Integer getNumber() {
        return issue.number;
    }


    public void setIssue(Issue issue) {
        this.issue = issue;
    }
}

