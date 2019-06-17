package com.js.android.core.di;

import com.js.android.core.languagepack.LanguagePackManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
class CoreModule {
    @Provides
    @Singleton
    LanguagePackManager provideLanguagePackManager() {
        return new LanguagePackManager();
    }
}
