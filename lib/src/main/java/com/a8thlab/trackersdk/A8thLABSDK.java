package com.a8thlab.trackersdk;

import android.content.Context;
import android.provider.Settings;
import android.util.Log;

import com.a8thlab.trackersdk.api.BluetoothCreator;
import com.a8thlab.trackersdk.api.DefaultBluetoothCreator;


/**
 * Created by Roman Bartusiak r.bartusiak@8thlab.com on 25.08.16.
 */
public class A8thLABSDK {

    private static BluetoothCreator bluetoothCreator=new DefaultBluetoothCreator();

    public static void initializeSDK(Context context, String appId, String appKey){
        Log.e("8thLAB tracker SDK","Library is not yet implemented fully!");
        String userId = Settings.Secure.getString(context.getContentResolver(),
                Settings.Secure.ANDROID_ID);
        bluetoothCreator.beginScanning(userId,appId,appKey);
    }

    public static void setBluetoothCreator(BluetoothCreator bluetoothCreator) {
        A8thLABSDK.bluetoothCreator = bluetoothCreator;
    }
}
