package com.a8thlab.trackersdk.api;

import android.os.AsyncTask;

/**
 * Created by Roman Bartusiak r.bartusiak@8thlab.com on 07.09.16.
 */
public class A8thLABAsyncInformer extends AsyncTask<String, Void, String> {
    private A8ThLabClient a8ThLabClient;

    public A8thLABAsyncInformer(A8ThLabClient a8ThLabClient) {
        this.a8ThLabClient = a8ThLabClient;
    }

    @Override
    protected String doInBackground(String... address) {
        a8ThLabClient.postToAPI(address[0]);
        return address[0];
    }
}
