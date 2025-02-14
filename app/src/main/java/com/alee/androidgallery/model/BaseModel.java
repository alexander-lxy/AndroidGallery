package com.alee.androidgallery.model;

import androidx.annotation.NonNull;

import com.alee.androidgallery.presenter.ICallBack;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BaseModel {
    protected <T> void executeRequest(Call<T> call, ICallBack<T> callback) {
        call.enqueue(new Callback<>() {
            @Override
            public void onResponse(@NonNull Call<T> call, @NonNull Response<T> response) {
                if (response.isSuccessful() && response.body() != null) {
                    callback.onSuccess(response.body());
                } else {
                    callback.onFailure(String.valueOf(response.code()));
                }
            }

            @Override
            public void onFailure(@NonNull Call<T> call, @NonNull Throwable t) {
                callback.onFailure(t.getMessage());
            }
        });
    }
}
