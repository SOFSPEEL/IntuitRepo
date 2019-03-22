package com.example.intuitrepos.di;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.example.intuitrepos.repository.IRepository;
import com.example.intuitrepos.vm.LoginViewModel;

import dagger.Module;
import dagger.Provides;

@Module
public class LoginViewModelFactoryModule {

    private IRepository repository;

    public LoginViewModelFactoryModule(IRepository repository) {

        this.repository = repository;
    }


}





