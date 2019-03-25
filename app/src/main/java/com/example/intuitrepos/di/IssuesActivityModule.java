package com.example.intuitrepos.di;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.example.intuitrepos.repository.IRepository;
import com.example.intuitrepos.views.screens.IssuesActivity;
import com.example.intuitrepos.vm.IssuesViewModel;

import dagger.Module;
import dagger.Provides;

@Module
public class IssuesActivityModule {

    private IssuesActivity issuesActivity;

    public IssuesActivityModule(IssuesActivity issuesActivity){

        this.issuesActivity = issuesActivity;
    }


    @Provides
    ViewModelProvider.Factory providesFactory(IRepository repository){
        return new ViewModelProvider.Factory() {
            @NonNull
            @Override
            public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
                return (T) new IssuesViewModel(repository);
            }
        };
    }


}
