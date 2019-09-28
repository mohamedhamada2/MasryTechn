package com.nglah.masrytechn.repository;

import com.nglah.masrytechn.network.networkModel.login.LoginRequest;
import com.nglah.masrytechn.network.networkModel.login.LoginResponse;
import com.nglah.masrytechn.network.networkModel.register.RegisterResponse;
import com.nglah.masrytechn.network.webservices.UserWebServices;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class UserRepository {

    private UserWebServices webServicesUSer;

    public UserRepository() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();
        String BASE_URL = "http://handasah.net/api/";
        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL).client(client).addConverterFactory(GsonConverterFactory.create()).addCallAdapterFactory(RxJava2CallAdapterFactory.create()).build();
        webServicesUSer = retrofit.create(UserWebServices.class);
    }

    // region singleton implementation
    private static class Loader {
        static UserRepository INSTANCE = new UserRepository();
    }


    public static UserRepository getInstance() {
        return Loader.INSTANCE;
    }


    public Observable<LoginResponse> loginRepository(final LoginRequest request) {
        return Observable.create(new ObservableOnSubscribe<LoginResponse>() {
            @Override
            public void subscribe(final ObservableEmitter<LoginResponse> emitter) {


                webServicesUSer.login(request).subscribeOn(Schedulers.io())
                        .observeOn(Schedulers.io()).subscribe(new Observer<LoginResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(LoginResponse response) {
                        emitter.onNext(response);
                    }

                    @Override
                    public void onError(Throwable e) {
                        LoginResponse response = new LoginResponse();
//                        response.setStatus(false);
//                        response.setMsg(e.toString());
                        emitter.onNext(response);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
            }
        });
    }

}
