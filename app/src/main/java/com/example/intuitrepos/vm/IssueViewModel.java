package com.example.intuitrepos.vm;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.view.View;

import com.example.intuitrepos.dto.Issue;

public class IssueViewModel extends BaseObservable {

    private final Issue issue;

    public IssueViewModel(Issue issue) {
        this.issue = issue;
    }

    @Bindable
    public String getTitle() {
        return issue.title;
    }

    @Bindable
    public Integer getNumber() {
        return issue.number;
    }


}

