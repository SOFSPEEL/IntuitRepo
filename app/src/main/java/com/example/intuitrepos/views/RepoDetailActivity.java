package com.example.intuitrepos.views;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.intuitrepos.R;
import com.example.intuitrepos.databinding.RepoDetailBinding;
import com.example.intuitrepos.dto.Repo;

public class RepoDetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        RepoDetailBinding binding = DataBindingUtil.setContentView(this, R.layout.repo_detail);

        Repo repo = getIntent().getParcelableExtra("repo");

        binding.setRepo(repo);




    }
}
