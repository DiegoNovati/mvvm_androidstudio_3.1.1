package com.template.mvvmtemplate.module;

import com.template.mvvmtemplate.MVVMTemplateApplication;

/**
 * Created by diegonovati on 18/04/2018.
 */

public class DependencyInjector {

    public static void initialize(MVVMTemplateApplication mvvmTemplateApplication) {
        appComponent = DaggerAppComponent
                .builder()
                .contextModule(new ContextModule(mvvmTemplateApplication))
                .build();
    }

    public static AppComponent getAppComponent() {
        return appComponent;
    }

    private DependencyInjector() {
    }

    private static AppComponent appComponent;
}
