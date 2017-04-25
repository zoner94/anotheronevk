package com.oximasoft.aov.mvp;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class BasePresenter<T extends MvpView> implements MvpPresenter<T> {

    private T mMvpView;
    private CompositeDisposable mCompositeDisposable = new CompositeDisposable();

    @Override
    public void attach(T view) {
        this.mMvpView = view;
    }

    @Override
    public void detach() {
        mCompositeDisposable.dispose();
        this.mMvpView = null;
    }

    @Override
    public T getView() {
        return mMvpView;
    }

    @Override
    public void addDisposable(Disposable disposable) {
        if (disposable == null)
            return;
        mCompositeDisposable.add(disposable);
    }
}
