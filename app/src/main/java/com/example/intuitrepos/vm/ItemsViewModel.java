package com.example.intuitrepos.vm;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.example.intuitrepos.repository.IRepository;

import java.util.List;

public abstract class ItemsViewModel<T> extends ViewModel {

    protected IRepository repository;
    protected LiveData<List<T>> items;

    public ItemsViewModel(IRepository repository) {

        this.repository = repository;
    }

    public abstract void fetch();

    public LiveData<List<T>> getItems() {
        return items;
    }
}
