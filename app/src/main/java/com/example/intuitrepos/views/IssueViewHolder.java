package com.example.intuitrepos.views;

import android.support.annotation.NonNull;

import com.example.intuitrepos.databinding.IssueRowBinding;
import com.example.intuitrepos.dto.Issue;

public class IssueViewHolder extends ItemViewHolder<Issue> {
    private IssueRowBinding issueRowBinding;

    public IssueViewHolder(@NonNull IssueRowBinding issueRowBinding, ISelectedItem selectedItem) {
        super(issueRowBinding, selectedItem);
        this.issueRowBinding = issueRowBinding;
    }

    @Override
    public void bind(Issue item, int position) {
        issueRowBinding.setIssue(item);
        super.bind(item, position);
    }
}
