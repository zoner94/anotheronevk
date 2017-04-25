package com.oximasoft.aov.mvp;

import io.reactivex.disposables.Disposable;

public interface MvpPresenter<T extends MvpView> {
    void attach(T view);

    void detach();

    T getView();

    void addDisposable(Disposable disposable);
}
