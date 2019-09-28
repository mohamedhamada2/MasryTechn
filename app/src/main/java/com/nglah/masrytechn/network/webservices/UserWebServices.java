package com.nglah.masrytechn.network.webservices;

import com.nglah.masrytechn.network.networkModel.forgetPAssword.ForgetPasswordRequest;
import com.nglah.masrytechn.network.networkModel.forgetPAssword.ForgetPasswordResponse;
import com.nglah.masrytechn.network.networkModel.login.LoginRequest;
import com.nglah.masrytechn.network.networkModel.login.LoginResponse;
import com.nglah.masrytechn.network.networkModel.register.RegiserRequest;
import com.nglah.masrytechn.network.networkModel.register.RegisterResponse;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface UserWebServices {


    @POST("person/register")
    @Headers({"Content-Type: application/json"})
    Observable<RegisterResponse> Registration(@Body RegiserRequest request);

    @POST("person/login")
    @Headers({"Content-Type: application/json"})
    Observable<LoginResponse> login(@Body LoginRequest request);


    @POST("person/password/email")
    @Headers({"Content-Type: application/json"})
    Observable<ForgetPasswordResponse> forgetPassword(@Body ForgetPasswordRequest request);



}
