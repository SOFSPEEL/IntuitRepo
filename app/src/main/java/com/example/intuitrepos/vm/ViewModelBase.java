package com.example.intuitrepos.vm;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.example.intuitrepos.repository.IRepository;

abstract class ViewModelBase extends ViewModel {

    protected IRepository repository;

    ViewModelBase(IRepository repository){
        this.repository = repository;
    }

    public abstract LiveData<String> getError();
}
