package com.example.intuitrepos;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;

import javax.inject.Provider;

import dagger.Module;
import dagger.Provides;

@Module
public class MainActivityModule {

    private MainActivity mainActivity;

    public MainActivityModule(MainActivity mainActivity){

        this.mainActivity = mainActivity;
    }

    @Provides
    ReposViewModelFactory providesRepoViewModelFactory(final Repository repository){
        return new ReposViewModelFactory(new Provider<ReposViewModel>() {
            @Override
            public ReposViewModel get() {
                return new ReposViewModel(repository);
            }
        });
    }

    @Provides
    ReposViewModel providesRepoViewModel(ReposViewModelFactory factory){
        return ViewModelProviders.of(mainActivity, factory).get(ReposViewModel.class);
    }

}





