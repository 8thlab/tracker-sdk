package com.a8thlab.trackersdk.api;

import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

/**
 * Created by Roman Bartusiak r.bartusiak@8thlab.com on 07.09.16.
 */
public class A8ThLabClient {
    private static final String A8THLAB_ENDPOINT="http://8thlab.com/api";

    private OkHttpClient httpClient;
    private String requestFormat;
    public static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");

    public A8ThLabClient(String userId, String appId, String appToken, OkHttpClient httpClient) {
        requestFormat= getRequestFormat(userId, appId, appToken);
        this.httpClient = httpClient;
    }

    private String getRequestFormat(String userId, String appId, String appToken) {
        return String.format("{\"userId\":\"%s\",\"appId\":\"%s\",\"appToken\":\"%s\",\"beaconAddress\":\"%s\"}",userId,appId,appToken,"%s");
    }

    public void beaconVisible(String address){
        new A8thLABAsyncInformer(this).execute(address);
    }

    private void tryToDoHttpRequest(Request request) {
        try {
            httpClient.newCall(request).execute().close();
        } catch (IOException e) {
            Log.e("8thLAB tracker SDK","Failed to do HTTP request");
        }
    }

    protected String postToAPI(String address) {
        Log.d("8thLAB tracker SDK",String.format("Found Bluetooth LE device %s",address));
        RequestBody body = RequestBody.create(JSON,String.format(requestFormat,address));
        Request request = new Request.Builder()
                .url(A8THLAB_ENDPOINT)
                .post(body)
                .build();
        tryToDoHttpRequest(request);
        return address;
    }
}
