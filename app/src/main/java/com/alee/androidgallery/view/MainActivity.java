package com.alee.androidgallery.view;

import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.alee.androidgallery.R;
import com.alee.androidgallery.presenter.TaskPresenter;

public class MainActivity extends BaseActivity<IMainView, TaskPresenter> implements IMainView {

    Button btnLogin;
    Button btnRegister;
    EditText etUsername;
    EditText etPassword;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        btnLogin = findViewById(R.id.btn_login);
        btnRegister = findViewById(R.id.btn_register);
        etUsername = findViewById(R.id.et_login_username);
        etPassword = findViewById(R.id.et_login_password);

        btnLogin.setOnClickListener(v -> presenter.login(etUsername.getText().toString(), etPassword.getText().toString()));
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showSuccess(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected TaskPresenter initPresenter() {
        return new TaskPresenter();
    }
}