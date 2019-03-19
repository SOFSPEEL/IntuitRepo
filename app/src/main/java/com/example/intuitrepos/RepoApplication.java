package com.example.intuitrepos;

import android.app.Application;

import com.example.intuitrepos.di.AppComponent;
import com.example.intuitrepos.di.AppModule;
import com.example.intuitrepos.di.DaggerAppComponent;

public class RepoApplication extends Application {

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerAppComponent.builder().appModule(new AppModule(getApplicationContext())).build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
