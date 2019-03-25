package com.example.intuitrepos.di;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.example.intuitrepos.repository.IRepository;
import com.example.intuitrepos.views.screens.IssueDetailActivity;
import com.example.intuitrepos.vm.IssueViewModel;

import dagger.Module;
import dagger.Provides;

@Module
public class IssueDetailActivityModule {

    private IssueDetailActivity issueDetailActivity;

    public IssueDetailActivityModule(IssueDetailActivity issueDetailActivity){

        this.issueDetailActivity = issueDetailActivity;
    }

    @Provides
    ViewModelProvider.Factory providesFactory(IRepository repository){
        return new ViewModelProvider.Factory() {
            @NonNull
            @Override
            public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
                return (T) new IssueViewModel();
            }
        };
    }

}
