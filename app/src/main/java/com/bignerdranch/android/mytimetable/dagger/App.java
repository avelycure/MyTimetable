package com.bignerdranch.android.mytimetable.dagger;

import android.app.Application;

public class App extends Application {
public AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.create();
    }
}
