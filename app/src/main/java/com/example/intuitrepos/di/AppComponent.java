package com.example.intuitrepos.di;

import com.example.intuitrepos.repository.IRepository;

import dagger.Component;

@Component(modules = {AppModule.class})
public interface AppComponent {


    IRepository getRepository();
}
