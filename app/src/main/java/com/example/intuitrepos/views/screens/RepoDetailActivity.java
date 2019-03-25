package com.example.intuitrepos.views.screens;

import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import com.example.intuitrepos.Constants;
import com.example.intuitrepos.R;
import com.example.intuitrepos.databinding.RepoDetailBinding;
import com.example.intuitrepos.di.DaggerRepoDetailActivityComponent;
import com.example.intuitrepos.di.RepoDetailActivityModule;
import com.example.intuitrepos.dto.Repo;
import com.example.intuitrepos.vm.RepoViewModel;

public class RepoDetailActivity extends DetailActivity<RepoViewModel, RepoDetailBinding> {

    private Repo repo;

    @Override
    protected String getTitleText() {
        return getString(R.string.repoDetail);
    }

    @Override
    protected void initializeViewModelFromParcelable(RepoViewModel viewModel) {
        super.initializeViewModelFromParcelable(viewModel);
        repo = getIntent().getParcelableExtra(Constants.EXTRA_KEY_ITEM);
        viewModel.setRepo(repo);
    }

    @Override
    protected Class<RepoViewModel> getViewModelClass() {
        return RepoViewModel.class;
    }

    @Override
    protected void inject() {
        DaggerRepoDetailActivityComponent.builder().appComponent(appComponent).repoDetailActivityModule(new RepoDetailActivityModule(this)).build().injectReposActivity(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.repo_detail;
    }

    @Override
    protected void setupBinding(RepoDetailBinding binding) {
        binding.setListener(this);
        binding.setRepo(viewModel);
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
