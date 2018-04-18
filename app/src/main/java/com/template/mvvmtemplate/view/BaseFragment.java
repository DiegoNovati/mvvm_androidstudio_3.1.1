package com.template.mvvmtemplate.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

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
 * This fragment is the base class for all the fragments. It receive the injections of all the
 * classes defined to be injected in the 'module' package
 */
public class BaseFragment extends Fragment {

    @Inject
    protected RuntimeData runtimeData;

    @Inject
    protected NetworkingService networkingService;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        try {
            super.onActivityCreated(savedInstanceState);

            // Here we will add the code to inject the dependencies
            onInject(DependencyInjector.getAppComponent());
        } catch (Exception ex) {
            logError(ex);
        }
    }

    public void logError(Throwable throwable) {
        ErrorManagement.logError(getActivity(), throwable);
    }

    protected void onInject(AppComponent appComponent) {
        if (appComponent != null) {
            appComponent.inject(this);
        }
    }
}
