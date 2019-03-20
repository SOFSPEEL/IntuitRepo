package com.example.intuitrepos.views;

import android.os.Bundle;

import com.example.intuitrepos.R;
import com.example.intuitrepos.dto.Repo;
import com.example.intuitrepos.vm.IssuesViewModel;
import com.example.intuitrepos.vm.ItemsViewModel;
import com.example.intuitrepos.vm.ReposViewModel;

import java.io.Serializable;

public class IssuesActivity extends ItemsActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    protected int getLayoutId() {
        return R.layout.repos;
    }

    @Override
    protected Class<IssuesViewModel> getItemsClass() {
        return IssuesViewModel.class;
    }

    @Override
    protected ItemsViewModel createItemsViewModel() {
        Repo repo = (Repo) getIntent().getParcelableExtra(Constants.EXTRA_KEY_ITEM);
        return new IssuesViewModel(appComponent.getRepository(), repo);
    }

    @Override
    protected ItemsAdapter createAdapter() {
        return new IssuesAdapter(this);
    }

    @Override
    protected Class<RepoDetailActivity> getDetailActivity() {
        return RepoDetailActivity.class;
    }

}
