package com.alee.androidgallery.presenter;

public interface ICallBack<T> {
    void onSuccess(T data);

    void onFailure(String errorMessage);
}
