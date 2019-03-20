package com.example.intuitrepos.views;

import com.example.intuitrepos.R;
import com.example.intuitrepos.vm.ItemsViewModel;
import com.example.intuitrepos.vm.ReposViewModel;

public class ReposActivity extends ItemsActivity {

    @Override
    protected int getLayoutId() {
        return R.layout.repos;
    }

    @Override
    protected Class<ReposViewModel> getItemsClass() {
        return ReposViewModel.class;
    }

    @Override
    protected ItemsViewModel createItemsViewModel() {
        return new ReposViewModel(appComponent.getRepository());
    }

    @Override
    protected ItemsAdapter createAdapter() {
        return new ReposAdapter(this);
    }

    @Override
    protected Class<RepoDetailActivity> getDetailActivity() {
        return RepoDetailActivity.class;
    }

}
