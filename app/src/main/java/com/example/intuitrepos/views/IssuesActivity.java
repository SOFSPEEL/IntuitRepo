package com.example.intuitrepos.views;

import android.os.Bundle;

import com.example.intuitrepos.R;
import com.example.intuitrepos.di.DaggerIssuesActivityComponent;
import com.example.intuitrepos.di.DaggerReposActivityComponent;
import com.example.intuitrepos.di.IssuesActivityComponent;
import com.example.intuitrepos.di.IssuesActivityModule;
import com.example.intuitrepos.di.ReposActivityComponent;
import com.example.intuitrepos.di.ReposActivityModule;
import com.example.intuitrepos.dto.Issue;
import com.example.intuitrepos.dto.Repo;
import com.example.intuitrepos.vm.IssuesViewModel;

public class IssuesActivity extends ItemsActivity<Issue, IssuesViewModel> {

    @Override
    protected void initializeViewModel(IssuesViewModel viewModel) {
        super.initializeViewModel(viewModel);

        Repo repo = getIntent().getParcelableExtra(Constants.EXTRA_KEY_ITEM);
        viewModel.setRepo(repo);
    }

    @Override
    protected void inject() {
        super.inject();
        IssuesActivityComponent build = DaggerIssuesActivityComponent.builder().issuesActivityModule(new IssuesActivityModule(this)).appComponent(appComponent).build();
        build.injectReposActivity(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.items;
    }

    @Override
    protected Class<IssuesViewModel> getItemsClass() {
        return IssuesViewModel.class;
    }

    @Override
    protected ItemsAdapter createAdapter() {
        return new IssuesAdapter(this);
    }

    @Override
    protected Class<IssueDetailActivity> getDetailActivity() {
        return IssueDetailActivity.class;
    }

}
