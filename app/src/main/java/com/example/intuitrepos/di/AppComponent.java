package com.example.intuitrepos.di;

import com.example.intuitrepos.repository.IRepository;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {


    IRepository getRepository();
}
