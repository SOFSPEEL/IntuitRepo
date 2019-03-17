package com.example.intuitrepos;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import javax.inject.Provider;

public class ReposViewModelFactory implements ViewModelProvider.Factory {
    private Provider<ReposViewModel> reposViewModelProvider;

    public ReposViewModelFactory(Provider<ReposViewModel> reposViewModelProvider) {

        this.reposViewModelProvider = reposViewModelProvider;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass == ReposViewModel.class) {
            return (T) reposViewModelProvider.get();
        } else throw new IllegalArgumentException("Junk");
    }
}
