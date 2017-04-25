package com.oximasoft.aov.authorization;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.oximasoft.aov.App;
import com.oximasoft.aov.R;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.annotations.NonNull;

public class AuthorizeActivity extends AppCompatActivity implements AuthorizeContract.View {

    @Inject
    AuthorizeContract.Presenter mPresenter;

    private WebView mWebView;
    private Observable<String> mUrlsHopObservable;
    private WebViewClient mWebViewClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((App) getApplication()).getAppComponent().inject(this);
        mPresenter.attach(this);
        setContentView(R.layout.activity_authorize);
        mUrlsHopObservable = Observable.create(emitter -> {
            mWebViewClient = new WebViewClient() {
                @Override
                public void onPageFinished(WebView view, String url) {
                    super.onPageFinished(view, url);
                    emitter.onNext(url);
                }
            };
            mWebView.setWebViewClient(mWebViewClient);
        });

        mWebView = (WebView) findViewById(R.id.log_in_wv);
        mPresenter.setUrlsHopObservable(mUrlsHopObservable);
        mPresenter.onCreateFinished();
    }

    @Override
    public void startLoading(String url) {
        mWebView.loadUrl(url);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.detach();
    }
}
