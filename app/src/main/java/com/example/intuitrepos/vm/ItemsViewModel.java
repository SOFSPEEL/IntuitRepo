package com.example.intuitrepos.vm;

import android.arch.lifecycle.LiveData;

import com.example.intuitrepos.repository.IRepository;

import java.util.List;

public abstract class ItemsViewModel<T> extends ViewModelBase {

    public ItemsViewModel(IRepository repository) {
        super(repository);
    }

    public abstract void fetch();

    public abstract LiveData<List<T>> getItems();

}
