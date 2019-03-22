package com.example.intuitrepos.views;

import android.view.View;

import com.example.intuitrepos.R;
import com.example.intuitrepos.databinding.IssueDetailBinding;
import com.example.intuitrepos.di.DaggerIssueDetailActivityComponent;
import com.example.intuitrepos.di.IssueDetailActivityComponent;
import com.example.intuitrepos.di.IssueDetailActivityModule;
import com.example.intuitrepos.dto.Issue;
import com.example.intuitrepos.vm.IssueViewModel;

public class IssueDetailActivity extends DetailActivity<IssueViewModel, IssueDetailBinding>  {

    @Override
    protected int getLayoutId() {
        return R.layout.issue_detail;
    }

    @Override
    protected void setupBinding(IssueDetailBinding binding) {
        binding.setListener(this);
        binding.setIssue(viewModel);
    }

    @Override
    protected void initializeViewModelFromParcelable(IssueViewModel viewModel) {
        super.initializeViewModelFromParcelable(viewModel);
        Issue issue = getIntent().getParcelableExtra(Constants.EXTRA_KEY_ITEM);
        viewModel.setIssue(issue);
    }

    @Override
    protected Class getViewModelClass() {
        return IssueViewModel.class;
    }

    @Override
    protected void inject() {
        DaggerIssueDetailActivityComponent.builder().appComponent(appComponent).issueDetailActivityModule(new IssueDetailActivityModule(this)).build().injectReposActivity(this);
    }

    @Override
    public void onClick(View view) {


    }

}
