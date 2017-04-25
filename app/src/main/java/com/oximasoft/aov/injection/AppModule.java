package com.oximasoft.aov.injection;

import android.content.Context;

import com.oximasoft.aov.authorization.AuthorizeContract;
import com.oximasoft.aov.authorization.AuthorizePresenter;
import com.oximasoft.aov.util.Preferences;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    Context mContext;

    public AppModule(Context mContext) {
        this.mContext = mContext;
    }

    @Provides
    @Singleton
    Preferences providePreferences() {
        return new Preferences(mContext);
    }

    @Provides
    @Singleton
    AuthorizeContract.Presenter provideAuthPresenter(Preferences preferences) {
        return new AuthorizePresenter(preferences);
    }
}
