package com.a8thlab.sdksample;

import android.Manifest;
import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.a8thlab.trackersdk.A8thLABSDK;
@TargetApi(Build.VERSION_CODES.M)
public class TrackerSDKTest extends AppCompatActivity {

    private static final int REQUEST_ENABLE_BT = 1;
    private static final int REQUEST_ENABLE_LOCATION = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tracker_sdktest);
        requestPermissions(new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, REQUEST_ENABLE_LOCATION);

    }

    private void run8thLabSDK() {
        String appId="APP_ID";
        String appToken="APP_TOKEN";
        A8thLABSDK.initializeSDK(getApplicationContext(), appId, appToken);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        if(REQUEST_ENABLE_LOCATION==requestCode&&grantResults[0]==0) {
            BluetoothManager bluetoothManager =
                    (BluetoothManager) getSystemService(Context.BLUETOOTH_SERVICE);
            BluetoothAdapter mBluetoothAdapter = bluetoothManager.getAdapter();
            if (mBluetoothAdapter == null || !mBluetoothAdapter.isEnabled()) {
                Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                startActivityForResult(enableBtIntent, REQUEST_ENABLE_BT);
            } else {
                run8thLabSDK();
            }
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==resultCode&&requestCode==REQUEST_ENABLE_BT){
            run8thLabSDK();
            }
    }

}
