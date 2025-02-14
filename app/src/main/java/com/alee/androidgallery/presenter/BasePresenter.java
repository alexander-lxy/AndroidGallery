package com.alee.androidgallery.presenter;

import com.alee.androidgallery.view.IBaseView;

import java.lang.ref.WeakReference;

public abstract class BasePresenter<V extends IBaseView>{
    protected WeakReference<V> viewRef;

    public void attachView(V view) {
        viewRef = new WeakReference<>(view);
    }

    public void detachView() {
        if (viewRef != null) {
            viewRef.clear();
            viewRef = null;
        }
    }

    public V getView() {
        return viewRef != null ? viewRef.get() : null;
    }

    public boolean isViewAttached() {
        return viewRef != null && viewRef.get() != null;
    }
}
