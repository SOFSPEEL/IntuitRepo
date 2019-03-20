package com.example.intuitrepos.views;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;

import com.example.intuitrepos.R;
import com.example.intuitrepos.databinding.RepoDetailBinding;
import com.example.intuitrepos.dto.Repo;
import com.example.intuitrepos.vm.RepoViewModel;

public class RepoDetailActivity extends DetailActivity  {

    private Repo repo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setupBinding();

    }
    private void setupBinding() {
        RepoDetailBinding binding = DataBindingUtil.setContentView(this, R.layout.repo_detail);
        binding.setListener(this);
        repo = getIntent().getParcelableExtra(Constants.EXTRA_KEY_ITEM);
        binding.setRepo(new RepoViewModel(repo));
    }
    @Override
    public void onClick(View view) {

        if (repo.openIssues > 0) {
            showList();
        } else {
            Toast.makeText(this, "This repo has no issues", Toast.LENGTH_SHORT).show();
        }
    }

    private void showList() {
        Intent intent = new Intent(this, IssuesActivity.class);
        intent.putExtra(Constants.EXTRA_KEY_ITEM, repo);
        startActivity(intent);
    }
}
