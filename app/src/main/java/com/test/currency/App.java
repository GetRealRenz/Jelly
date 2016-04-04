package com.test.currency;

import android.app.Application;
import android.content.Context;

import com.test.currency.api.ApiManager;

/**
 * Created by Антон on 04.04.2016.
 */
public class App extends Application {
    private static Context sContext;
    private static ApiManager sApiManager;

    @Override
    public void onCreate() {
        super.onCreate();
        App.sContext=getApplicationContext();
    }
    public static ApiManager getApiManager() {
        if (sApiManager == null) {
            sApiManager = new ApiManager();
            sApiManager.init(getContext());
        }
        return sApiManager;
    }
    public static Context getContext() {
        return sContext;
    }
}
