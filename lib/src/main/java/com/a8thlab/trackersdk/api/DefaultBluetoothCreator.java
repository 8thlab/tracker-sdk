package com.a8thlab.trackersdk.api;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanFilter;
import android.bluetooth.le.ScanResult;
import android.bluetooth.le.ScanSettings;
import android.os.Build;
import android.os.Handler;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;

/**
 * Created by Roman Bartusiak r.bartusiak@8thlab.com on 07.09.16.
 */

@TargetApi(Build.VERSION_CODES.LOLLIPOP)
public class DefaultBluetoothCreator implements BluetoothCreator{

    private Handler scanHandler = new Handler();
    private List<ScanFilter> scanFilters = new ArrayList<ScanFilter>();
    private ScanSettings scanSettings;

    public void beginScanning(String appId,String appToken,String userId) {
        ScanSettings.Builder scanSettingsBuilder = new ScanSettings.Builder();
        scanSettingsBuilder.setScanMode(ScanSettings.SCAN_MODE_LOW_LATENCY);
        scanSettings = scanSettingsBuilder.build();
        DefaultScanCallback defaultScanCallback=new DefaultScanCallback(new A8ThLabClient(userId,appId,appToken,new OkHttpClient()));
        DefaultScanRunnable defaultScanRunnable=new DefaultScanRunnable(scanHandler,defaultScanCallback,scanSettings,scanFilters);
        scanHandler.post(defaultScanRunnable);
    }


}


