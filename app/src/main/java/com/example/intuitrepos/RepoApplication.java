package com.example.intuitrepos;

import android.app.Application;

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
