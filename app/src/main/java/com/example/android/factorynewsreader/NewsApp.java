package com.example.android.factorynewsreader;

import android.app.Application;
import android.content.Context;

public class NewsApp extends Application {

    private static Context appContext;

    @Override
    public void onCreate() {
        super.onCreate();
        appContext = getApplicationContext();
    }

    public static Context getAppContext() {
        return appContext;
    }
}
