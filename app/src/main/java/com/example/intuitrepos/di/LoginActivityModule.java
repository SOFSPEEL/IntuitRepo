package com.example.intuitrepos.di;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.example.intuitrepos.repository.IRepository;
import com.example.intuitrepos.views.screens.LoginActivity;
import com.example.intuitrepos.vm.LoginViewModel;

import dagger.Module;
import dagger.Provides;

@Module
public class LoginActivityModule {

    private LoginActivity loginActivity;

    public LoginActivityModule(LoginActivity loginActivity){

        this.loginActivity = loginActivity;
    }

    @Provides
    ViewModelProvider.Factory providesFactory(IRepository repository){
        return new ViewModelProvider.Factory() {
            @NonNull
            @Override
            public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
                return (T) new LoginViewModel(repository);
            }
        };
    }

}
