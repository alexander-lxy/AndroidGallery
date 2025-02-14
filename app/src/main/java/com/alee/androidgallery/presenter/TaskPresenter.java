package com.alee.androidgallery.presenter;

import com.alee.androidgallery.entity.User;
import com.alee.androidgallery.model.TaskModel;
import com.alee.androidgallery.view.IBaseView;
import com.alee.androidgallery.view.IMainView;

public class TaskPresenter extends BasePresenter<IMainView> {
    //如果你在子类中不需要改变泛型类型或扩展泛型，不需要再写 <V extends IBaseView>

    private TaskModel taskModel = null;


    public TaskPresenter() {
        taskModel = new TaskModel();
    }

    public void login(String username, String password) {
         taskModel.login(username, password, new ICallBack<>() {
             @Override
             public void onSuccess(User data) {
                 if (isViewAttached()) {
                     getView().showSuccess("Login success");
                 }
             }

             @Override
             public void onFailure(String errorMessage) {
                 if (isViewAttached()) {
                     getView().showError(errorMessage);
                 }
             }
         });
    }



}
