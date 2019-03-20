package com.example.intuitrepos.di;

import android.arch.lifecycle.ViewModelProviders;

import com.example.intuitrepos.views.ReposActivity;
import com.example.intuitrepos.vm.ItemsViewModelFactory;
import com.example.intuitrepos.vm.ReposViewModel;
import com.example.intuitrepos.repository.Repository;

import javax.inject.Provider;

import dagger.Module;
import dagger.Provides;

@Module
public class MainActivityModule {

    private ReposActivity reposActivity;

    public MainActivityModule(ReposActivity reposActivity){

        this.reposActivity = reposActivity;
    }



}





