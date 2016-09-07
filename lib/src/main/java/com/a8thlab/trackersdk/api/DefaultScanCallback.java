package com.a8thlab.trackersdk.api;

import android.annotation.TargetApi;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanResult;
import android.os.Build;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

/**
 * Created by Roman Bartusiak r.bartusiak@8thlab.com on 07.09.16.
 */
@TargetApi(Build.VERSION_CODES.LOLLIPOP)
public class DefaultScanCallback extends ScanCallback {


    private A8ThLabClient a8ThLabClient;

    public DefaultScanCallback(A8ThLabClient a8ThLabClient) {
        this.a8ThLabClient = a8ThLabClient;
    }

    @Override
    public void onScanResult(int callbackType, ScanResult result) {
        super.onScanResult(callbackType, result);
        a8ThLabClient.beaconVisible(result.getDevice().getAddress());
    }

    @Override
    public void onScanFailed(int errorCode) {
        super.onScanFailed(errorCode);

    }
}
