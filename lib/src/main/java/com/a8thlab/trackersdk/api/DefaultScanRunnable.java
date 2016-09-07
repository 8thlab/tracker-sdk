package com.a8thlab.trackersdk.api;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanFilter;
import android.bluetooth.le.ScanSettings;
import android.os.Build;
import android.os.Handler;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Roman Bartusiak r.bartusiak@8thlab.com on 07.09.16.
 */
@TargetApi(Build.VERSION_CODES.LOLLIPOP)
public class DefaultScanRunnable implements Runnable{
    private Handler scanHandler;
    ScanCallback scanCallback;
    private ScanSettings scanSettings;
    private List<ScanFilter> scanFilters;
    private boolean isScanning = false;
    private static final int SCAN_INTERVAL_MS = 250;

    public DefaultScanRunnable(Handler scanHandler,
                               ScanCallback scanCallback,
                               ScanSettings scanSettings,
                               List<ScanFilter> scanFilters) {
        this.scanHandler = scanHandler;
        this.scanCallback = scanCallback;
        this.scanSettings = scanSettings;
        this.scanFilters = scanFilters;
    }

    @Override
    public void run() {
        BluetoothLeScanner scanner = BluetoothAdapter.getDefaultAdapter().getBluetoothLeScanner();

        if (isScanning) {
            scanner.stopScan(scanCallback);
        } else {
            scanner.startScan(scanFilters, scanSettings, scanCallback);
        }

        isScanning = !isScanning;

        scanHandler.postDelayed(this, SCAN_INTERVAL_MS);
    }
}
