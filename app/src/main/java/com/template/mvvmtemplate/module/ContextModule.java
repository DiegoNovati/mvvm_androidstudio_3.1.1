package com.template.mvvmtemplate.module;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by diegonovati on 18/04/2018.
 */

@Module
public class ContextModule {

    public ContextModule(Context context) {
        this.context = context;
    }

    @Provides
    @Singleton
    public Context getContext() {
        return context;
    }

    private final Context context;
}
