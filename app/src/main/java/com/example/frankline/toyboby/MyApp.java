package com.example.frankline.toyboby;

import android.app.Application;

import com.activeandroid.ActiveAndroid;

public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        ActiveAndroid.initialize(this);

    }
}
