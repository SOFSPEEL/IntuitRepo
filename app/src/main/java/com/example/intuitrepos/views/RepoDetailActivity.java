package com.example.intuitrepos.views;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.intuitrepos.R;
import com.example.intuitrepos.databinding.RepoDetailBinding;
import com.example.intuitrepos.dto.Repo;

public class RepoDetailActivity extends AppCompatActivity implements View.OnClickListener {
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
        binding.setRepo(repo);
    }


    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this, IssuesActivity.class);
        intent.putExtra("issuesUrl", repo.issuesUrl);
        startActivity(intent);
    }
}
