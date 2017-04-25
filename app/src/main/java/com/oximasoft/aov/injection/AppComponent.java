package com.oximasoft.aov.injection;

import com.oximasoft.aov.authorization.AuthorizeActivity;

import javax.inject.Singleton;

import dagger.Component;

@Component(modules = AppModule.class)
@Singleton
public interface AppComponent {

    void inject(AuthorizeActivity app);
}
