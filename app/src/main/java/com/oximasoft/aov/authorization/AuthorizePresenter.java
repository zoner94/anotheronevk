package com.oximasoft.aov.authorization;

import com.oximasoft.aov.mvp.BasePresenter;
import com.oximasoft.aov.util.Preferences;

import io.reactivex.Observable;

public class AuthorizePresenter extends BasePresenter<AuthorizeContract.View>
        implements AuthorizeContract.Presenter {

    private Preferences mPreferences;

    public AuthorizePresenter(Preferences mPreferences) {
        this.mPreferences = mPreferences;
    }

    @Override
    public void onCreateFinished() {
        getView().startLoading(LoginConfig.configureLoginUrl(LoginConfig.Scope.FRIENDS));
    }

    @Override
    public void setUrlsHopObservable(Observable<String> urlsHopObservable) {
        addDisposable(urlsHopObservable
                .filter(url -> url.contains(LoginConfig.TOKEN_FILTER))
                .map(url -> url.substring(url.indexOf(LoginConfig.TOKEN_FILTER) +
                        LoginConfig.TOKEN_FILTER.length() + 1, url.indexOf("&expires_in")))
                .subscribe(token -> {
                }, Throwable::printStackTrace));
    }

}
