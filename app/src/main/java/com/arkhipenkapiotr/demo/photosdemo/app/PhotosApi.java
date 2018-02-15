package com.arkhipenkapiotr.demo.photosdemo.app;

import com.arkhipenkapiotr.demo.photosdemo.app.api_models.SignRequestBody;
import com.arkhipenkapiotr.demo.photosdemo.app.api_models.UserDTO;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by arhip on 15.02.2018.
 */

public interface PhotosApi {

    @POST("/api/account/signin")
    Call<UserDTO> signIn (@Body SignRequestBody signRequest);

    @POST("/api/account/signup")
    Call<UserDTO> signUp (@Body SignRequestBody signRequest);
}
