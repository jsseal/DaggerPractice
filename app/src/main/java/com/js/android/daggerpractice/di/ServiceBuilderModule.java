package com.js.android.daggerpractice.di;

import com.js.android.daggerpractice.HoneyBoard;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ServiceBuilderModule {

    @ContributesAndroidInjector
    abstract HoneyBoard contributesHoneyBoard();
}
