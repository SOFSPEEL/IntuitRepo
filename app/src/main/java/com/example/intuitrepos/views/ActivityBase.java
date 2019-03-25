package com.example.intuitrepos.views;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.intuitrepos.RepoApplication;
import com.example.intuitrepos.di.AppComponent;

import javax.inject.Inject;

public abstract class ActivityBase<TViewModel extends ViewModel> extends AppCompatActivity {

    @Inject
    ViewModelProvider.Factory viewModelFactory;

    protected AppComponent appComponent;
    protected TViewModel viewModel;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTitle(getTitleText());

        RepoApplication app = (RepoApplication) getApplication();
        appComponent = app.getAppComponent();
        inject();
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(getViewModelClass());
        initializeViewModelFromParcelable(viewModel);
    }

    protected abstract String getTitleText();

    protected void initializeViewModelFromParcelable(TViewModel viewModel) {
    }

    protected abstract Class<TViewModel> getViewModelClass();

    protected abstract void inject();
}
