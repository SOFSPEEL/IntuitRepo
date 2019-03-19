package com.example.intuitrepos.di;

import android.arch.lifecycle.ViewModelProviders;

import com.example.intuitrepos.views.ReposActivity;
import com.example.intuitrepos.vm.ReposViewModel;
import com.example.intuitrepos.vm.ReposViewModelFactory;
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
        return ViewModelProviders.of(reposActivity, factory).get(ReposViewModel.class);
    }

}





