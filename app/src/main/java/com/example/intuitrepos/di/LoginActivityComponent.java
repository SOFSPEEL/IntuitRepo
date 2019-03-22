package com.example.intuitrepos.di;

import android.arch.lifecycle.ViewModelProvider;

import com.example.intuitrepos.repository.Repository;
import com.example.intuitrepos.views.LoginActivity;
import com.example.intuitrepos.vm.LoginViewModel;

import dagger.Component;

@Singleton2
@Component(modules = {LoginActivityModule.class}, dependencies = {AppComponent.class})

public interface LoginActivityComponent {
    void injectLoginActivity(LoginActivity loginActivity);
    ViewModelProvider.Factory getFactory();
}
