package com.alee.androidgallery.view;

public interface IMainView extends IBaseView{
    void showProgress();
    void hideProgress();
    void showError(String message);
    void showSuccess(String message);
}
