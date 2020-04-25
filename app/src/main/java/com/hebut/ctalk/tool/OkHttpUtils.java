package com.hebut.ctalk.tool;

import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class OkHttpUtils {
    private String TAG = "MyOkHttp";
    private final OkHttpClient client = new OkHttpClient();
    private final String url = "http://192.168.0.104:8001/";
    private final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    public void doGet(String path){

        Request request = new Request.Builder()
                .url(url+path)
                .build();
        Log.i(TAG, "doGet: ");
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.i(TAG, "onFailure: ");
                e.printStackTrace();
            }
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                try (ResponseBody responseBody = response.body()) {
                    if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

                    Headers responseHeaders = response.headers();
                    for (int i = 0, size = responseHeaders.size(); i < size; i++) {
                        Log.i(TAG, responseHeaders.name(i) + ": " + responseHeaders.value(i));
                    }

                    Log.i(TAG, responseBody.string());
                }
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void doPost(String path, String json){
        Request request = new Request.Builder()
                .url(url+path)
                .post(RequestBody.create(JSON,json))
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

            System.out.println(response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
