package com.a8thlab.trackersdk.api;

import android.content.Context;

/**
 * Created by Roman Bartusiak r.bartusiak@8thlab.com on 07.09.16.
 */
public interface BluetoothCreator {
    void beginScanning(String appId, String appToken, String userId);
}
