package com.js.android.core.di;

import com.js.android.core.languagepack.LanguagePackManager;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component( modules = {
        CoreModule.class,
})
public interface CoreComponent {
    LanguagePackManager getLanguagePackManager();
}
