package com.example.nazmuddinmavliwala.languagelist.base.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.nazmuddinmavliwala.languagelist.app.LanguageListApp;
import com.example.nazmuddinmavliwala.languagelist.base.HasComponent;
import com.example.nazmuddinmavliwala.languagelist.base.di.BaseActivityComponent;
import com.example.nazmuddinmavliwala.languagelist.base.di.BaseActivityModule;
import com.example.nazmuddinmavliwala.languagelist.base.di.DaggerBaseActivityComponent;
import com.example.nazmuddinmavliwala.languagelist.base.di.RxModule;

/**
 * Created by nazmuddinmavliwala on 27/10/2017.
 */

public abstract class BaseActivity extends AppCompatActivity implements HasComponent<BaseActivityComponent> {

    private BaseActivityComponent component;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        this.component = DaggerBaseActivityComponent.builder()
                .applicationComponent(LanguageListApp.getComponent())
                .baseActivityModule(new BaseActivityModule(this))
                .rxModule(new RxModule())
                .build();
        this.component.inject(this);
    }

    protected abstract int getLayout();

    @Override
    public BaseActivityComponent getComponent() {
        return this.component;
    }

}
