package com.js.android.daggerpractice.di;

import android.app.Application;

import com.js.android.core.di.CoreComponent;
import com.js.android.daggerpractice.AuthActivity;
import com.js.android.daggerpractice.BaseApplication;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Component (
        modules = {
                AndroidSupportInjectionModule.class,
                ActivityBuilderModule.class,
                ServiceBuilderModule.class,
                AppModule.class,
        },
        dependencies = {
                CoreComponent.class,
        }
)
@AppScope
public interface AppComponent extends AndroidInjector<BaseApplication> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);
        Builder coreComponent(CoreComponent coreComponent);
        AppComponent build();
    }

}
