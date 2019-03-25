package com.example.intuitrepos.views.viewholder;

import android.support.annotation.NonNull;

import com.example.intuitrepos.databinding.IssueRowBinding;
import com.example.intuitrepos.dto.Issue;
import com.example.intuitrepos.views.CallbackSelected;

public class IssueViewHolder extends ItemViewHolder<Issue> {
    private IssueRowBinding issueRowBinding;

    public IssueViewHolder(@NonNull IssueRowBinding issueRowBinding, CallbackSelected callbackSelected) {
        super(issueRowBinding, callbackSelected);
        this.issueRowBinding = issueRowBinding;
    }

    @Override
    public void bind(Issue item, int position) {
        issueRowBinding.setIssue(item);
        super.bind(item, position);
    }
}
