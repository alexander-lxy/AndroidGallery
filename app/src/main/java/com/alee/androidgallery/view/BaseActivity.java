package com.alee.androidgallery.view;

import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.alee.androidgallery.R;
import com.alee.androidgallery.presenter.BasePresenter;

public abstract class BaseActivity<V extends IBaseView, P extends BasePresenter> extends AppCompatActivity {

    protected P presenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(getLayoutId());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        initView();
        presenter = initPresenter();
        if (presenter != null && this instanceof IBaseView) {
            presenter.attachView((V)this);
        }
    }

    protected abstract int getLayoutId();

    protected abstract void initView();

    protected abstract P initPresenter();

    @Override
    protected void onDestroy() {
        if (presenter != null) {
            presenter.detachView();
        }
        super.onDestroy();
    }
}
