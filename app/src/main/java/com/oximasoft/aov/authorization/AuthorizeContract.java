package com.oximasoft.aov.authorization;

import com.oximasoft.aov.mvp.MvpPresenter;
import com.oximasoft.aov.mvp.MvpView;

import io.reactivex.Observable;

public interface AuthorizeContract {

    public interface View extends MvpView {
        void startLoading(String uri);
    }

    public interface Presenter extends MvpPresenter<View> {
        void setUrlsHopObservable(Observable<String> urlsHopObservable);

        void onCreateFinished();
    }
}
