package com.template.mvvmtemplate.viewmodel;

import android.app.Activity;

import com.template.mvvmtemplate.error.ErrorManagement;
import com.template.mvvmtemplate.model.RuntimeData;
import com.template.mvvmtemplate.module.AppComponent;
import com.template.mvvmtemplate.module.DependencyInjector;
import com.template.mvvmtemplate.service.NetworkingService;

import javax.inject.Inject;

/**
 * Created by diegonovati on 18/04/2018.
 */

/**
 * This viewmodel is the base class for all the viewmodels. It receive the injections of all the
 * classes defined to be injected in the 'module' package
 */
public class BaseViewModel {

    @Inject
    protected RuntimeData runtimeData;

    @Inject
    protected NetworkingService networkingService;

    public BaseViewModel(Activity activity) {
        try {
            this.activity = activity;
            // Here we will add the code to inject the dependencies
            onInject(DependencyInjector.getAppComponent());
        } catch (Exception ex) {
            logError(ex);
        }
    }

    public void logError(Throwable throwable) {
        ErrorManagement.logError(activity, throwable);
    }

    protected void onInject(AppComponent appComponent) {
        if (appComponent != null) {
            appComponent.inject(this);
        }
    }

    protected Activity activity;
}
