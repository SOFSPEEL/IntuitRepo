package com.example.intuitrepos.di;

import android.arch.lifecycle.ViewModelProvider;

public interface IFactory {
    ViewModelProvider.Factory getFactory();
}
