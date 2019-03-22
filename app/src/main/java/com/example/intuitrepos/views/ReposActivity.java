package com.example.intuitrepos.views;

import com.example.intuitrepos.R;
import com.example.intuitrepos.di.DaggerReposActivityComponent;
import com.example.intuitrepos.di.ReposActivityComponent;
import com.example.intuitrepos.di.ReposActivityModule;
import com.example.intuitrepos.vm.ReposViewModel;

public class ReposActivity extends ItemsActivity {

    @Override
    protected void inject() {
        super.inject();
        ReposActivityComponent build = DaggerReposActivityComponent.builder().reposActivityModule(new ReposActivityModule(this)).appComponent(appComponent).build();
        build.injectReposActivity(this);
    }


    @Override
    protected int getLayoutId() {
        return R.layout.items;
    }

    @Override
    protected Class<ReposViewModel> getItemsClass() {
        return ReposViewModel.class;
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
