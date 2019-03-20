package com.example.intuitrepos.vm;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import javax.inject.Provider;

public class ItemsViewModelFactory implements ViewModelProvider.Factory {

    private Provider<ItemsViewModel> itemsViewModelProvider;

    public ItemsViewModelFactory(Provider<ItemsViewModel> itemsViewModelProvider) {

        this.itemsViewModelProvider = itemsViewModelProvider;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {

        if (modelClass == ReposViewModel.class) {
            return (T) itemsViewModelProvider.get();
        } else  if (modelClass == IssuesViewModel.class) {
            return (T) itemsViewModelProvider.get();
        }

        else throw new IllegalArgumentException("Junk");
    }
}
