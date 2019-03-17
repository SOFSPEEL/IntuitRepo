package com.example.intuitrepos;

import dagger.Component;

@Component(modules = {AppModule.class})
public interface AppComponent {

    RepoService getRepoService();
}
