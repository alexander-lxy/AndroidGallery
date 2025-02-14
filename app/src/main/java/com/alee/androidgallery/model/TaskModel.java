package com.alee.androidgallery.model;

import com.alee.androidgallery.apiservice.ApiService;
import com.alee.androidgallery.apiservice.RetrofitClient;
import com.alee.androidgallery.entity.User;
import com.alee.androidgallery.presenter.ICallBack;

import retrofit2.Call;

public class TaskModel extends BaseModel {

    private ApiService apiService = null;

    public TaskModel() {
        apiService = RetrofitClient.createService(ApiService.class);
    }

    public void login(String username, String password, ICallBack<User> callback) {
        Call<User> call = apiService.login(username, password);
        super.executeRequest(call, callback);
    }

    public void register(String username, String password, String email, ICallBack<User> callback) {
        Call<User> call = apiService.register(username, password, email);
        super.executeRequest(call, callback);
    }

}
