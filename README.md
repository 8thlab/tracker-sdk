# 8thLAB Android Tracker SDK

[![Build Status](https://travis-ci.org/8thlab/tracker-sdk-android.svg?branch=master)](https://travis-ci.org/8thlab/tracker-sdk-android)

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
A8thLABSDK.initialize(applicationContext, appId, appToken);

```