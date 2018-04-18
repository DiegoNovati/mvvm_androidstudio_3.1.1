package com.template.mvvmtemplate;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.arch.lifecycle.ProcessLifecycleOwner;
import android.support.multidex.MultiDexApplication;

import com.template.mvvmtemplate.error.ErrorManagement;
import com.template.mvvmtemplate.module.DependencyInjector;

/**
 * Created by diegonovati on 18/04/2018.
 */

public class MVVMTemplateApplication extends MultiDexApplication implements LifecycleObserver {

    @Override
    public void onCreate() {
        try {
            super.onCreate();

            // Here we will add the code to inject the dependencies
            injectDependencies();

            setupLifecycleListener();
        } catch (Exception ex) {
            logError(ex);
        }
    }

    /**
     * Method called when the app goes in the foreground. Here we can restore data saved when the App
     * went in the background
     */
    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void onMoveToForeground() {
    }

    /**
     * Method calles when the app goes in the background. Here we can persist the runtime data
     */
    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void onMoveToBackground() {
    }

    private void setupLifecycleListener() {
        ProcessLifecycleOwner.get().getLifecycle().addObserver(this);
    }

    private void injectDependencies() {
        DependencyInjector.initialize(this);
        DependencyInjector.getAppComponent().inject(this);
    }

    private void logError(Throwable throwable) {
        ErrorManagement.logError(this, throwable);
    }
}
