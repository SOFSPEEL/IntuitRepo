package com.example.intuitrepos.views;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;

import com.example.intuitrepos.R;
import com.example.intuitrepos.databinding.IssueDetailBinding;
import com.example.intuitrepos.databinding.RepoDetailBinding;
import com.example.intuitrepos.dto.Issue;
import com.example.intuitrepos.vm.IssueViewModel;
import com.example.intuitrepos.vm.RepoViewModel;

public class IssueDetailActivity extends DetailActivity  {

    private Issue issue;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setupBinding();

    }
    private void setupBinding() {
        IssueDetailBinding binding = DataBindingUtil.setContentView(this, R.layout.issue_detail);
        binding.setListener(this);
        issue = getIntent().getParcelableExtra(Constants.EXTRA_KEY_ITEM);
        binding.setIssue(new IssueViewModel(issue));
    }
    @Override
    public void onClick(View view) {


    }

}
