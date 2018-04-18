package com.template.mvvmtemplate.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

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
 * This activity is the base class for all the activies. It receive the injections of all the
 * classes defined to be injected in the 'module' package
 */
public class BaseActivity extends AppCompatActivity {

    @Inject
    protected RuntimeData runtimeData;

    @Inject
    protected NetworkingService networkingService;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);

            // Here we will add the code to inject the dependencies
            onInject(DependencyInjector.getAppComponent());
        } catch (Exception ex) {
            logError(ex);
        }
    }

    public void logError(Throwable throwable) {
        ErrorManagement.logError(this, throwable);
    }

    protected void onInject(AppComponent appComponent) {
        if (appComponent != null) {
            appComponent.inject(this);
        }
    }
}
