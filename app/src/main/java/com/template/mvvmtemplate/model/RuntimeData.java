package com.template.mvvmtemplate.model;

/**
 * Created by diegonovati on 18/04/2018.
 */

import android.content.Context;

/**
 * This class contains all the runtime data and it is injected with dagger to Application, Activities,
 * Fragments and ViewModels.
 */
public class RuntimeData {

    public RuntimeData(Context context) {
        this.context = context;
    }

    private Context context;
}
