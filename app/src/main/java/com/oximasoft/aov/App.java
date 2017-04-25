package com.oximasoft.aov;

import android.app.Application;

import com.oximasoft.aov.injection.AppComponent;
import com.oximasoft.aov.injection.AppModule;
import com.oximasoft.aov.injection.DaggerAppComponent;

public class App extends Application {

    private AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mAppComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    public AppComponent getAppComponent() {
        return mAppComponent;
    }
}
