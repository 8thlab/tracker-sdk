package com.a8thlab.sdksample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.a8thlab.trackersdk.A8thLABSDK;

public class TrackerSDKTest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tracker_sdktest);
 		String appId="APP_ID";
        String appToken="APP_TOKEN";
        A8thLABSDK.initializeSDK(getApplicationContext(), appId, appToken);
    }
}
