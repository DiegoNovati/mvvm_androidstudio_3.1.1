package com.template.mvvmtemplate.service;

import android.content.Context;

import com.template.mvvmtemplate.model.RuntimeData;
import com.template.mvvmtemplate.service.api.NetworkingAPI;

/**
 * Created by diegonovati on 18/04/2018.
 */

/**
 * This class implements the connections with the backend using Retrofit
 */
public class NetworkingService {

    public NetworkingService(Context context, NetworkingAPI networkingAPI, RuntimeData runtimeData) {
        this.context = context;
        this.networkingAPI = networkingAPI;
        this.runtimeData = runtimeData;
    }

    private Context context;
    private NetworkingAPI networkingAPI;
    private RuntimeData runtimeData;
}
