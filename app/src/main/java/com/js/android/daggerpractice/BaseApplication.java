package com.js.android.daggerpractice;

import android.app.Application;
import android.util.Log;

import com.js.android.core.di.CoreComponent;
import com.js.android.core.di.CoreComponentProvider;
import com.js.android.core.di.DaggerCoreComponent;
import com.js.android.daggerpractice.di.DaggerAppComponent;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;

public class BaseApplication extends DaggerApplication implements CoreComponentProvider {

    private static final String TAG = "Dagger";

    private CoreComponent mCoreComponent;

    @Inject
    String test;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate is called");

        if(test != null) {
            Log.d(TAG, "onCreate: " + test);
        }
    }

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerAppComponent.builder().application(this).coreComponent(provideCoreComponent()).build();
    }

    @Override
    public CoreComponent provideCoreComponent() {
        if (mCoreComponent == null) {
            mCoreComponent = DaggerCoreComponent.builder().build();
        }
        return mCoreComponent;
    }
}
