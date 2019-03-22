package com.example.intuitrepos.views;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;

import com.example.intuitrepos.R;
import com.example.intuitrepos.databinding.LoginBinding;
import com.example.intuitrepos.di.DaggerLoginActivityComponent;
import com.example.intuitrepos.di.LoginActivityComponent;
import com.example.intuitrepos.di.LoginActivityModule;
import com.example.intuitrepos.vm.LoginViewModel;

import javax.inject.Inject;

public class LoginActivity extends ActivityBase<LoginViewModel> implements View.OnClickListener {

    @Inject
    ViewModelProvider.Factory viewModelFactory;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LoginBinding binding = DataBindingUtil.setContentView(this, R.layout.login);
        binding.setListener(this);
        binding.setLogin(viewModel);
    }

    @Override
    protected Class<LoginViewModel> getItemsClass() {
        return LoginViewModel.class;
    }

    @Override
    protected void inject() {
        super.inject();
        LoginActivityComponent build = DaggerLoginActivityComponent.builder().loginActivityModule(new LoginActivityModule(this)).appComponent(appComponent).build();
        build.injectLoginActivity(this);
    }

    @Override
    public void onClick(View view) {
        viewModel.saveCreds();
        startActivity(new Intent(this, ReposActivity.class));
    }
}
