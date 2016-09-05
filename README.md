# 8thLAB Android Tracker SDK

[![Build Status](https://travis-ci.org/8thlab/tracker-sdk-android.svg?branch=master)](https://travis-ci.org/8thlab/tracker-sdk-android) [![Gitter](https://badges.gitter.im/8thlab/tracker-sdk-android.svg)](https://gitter.im/8thlab/tracker-sdk-android?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge)

LIBRARY IS UNDER HEAVY DEVELOPMENT!

# Usage

## Dependency

Currently only snapshot version is available

### Snapshot

```
repositories {
    maven {
        url "https://oss.sonatype.org/content/repositories/snapshots"
    }
}

dependencies {
    compile 'com.8thlab:trackersdk:0.0.1-SNAPSHOT@aar'
}
```

## Initialization

```
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

```
