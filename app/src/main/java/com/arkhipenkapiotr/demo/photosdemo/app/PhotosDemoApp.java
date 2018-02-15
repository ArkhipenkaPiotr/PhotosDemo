package com.arkhipenkapiotr.demo.photosdemo.app;

import android.app.Application;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by arhip on 15.02.2018.
 */

public class PhotosDemoApp extends Application {

    private Retrofit retrofit;
    private static PhotosApi photosApi = null;

    @Override
    public void onCreate() {
        super.onCreate();

        retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.180.4:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        photosApi = retrofit.create(PhotosApi.class);
    }

    public static PhotosApi getApi(){
        return photosApi;
    }
}
