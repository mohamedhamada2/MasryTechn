package com.nglah.masrytechn.viewModel;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.nglah.masrytechn.DataBase.DataBase;
import com.nglah.masrytechn.model.UserModel;
import com.nglah.masrytechn.network.networkModel.login.LoginRequest;
import com.nglah.masrytechn.network.networkModel.login.LoginResponse;
import com.nglah.masrytechn.repository.UserRepository;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

import static com.nglah.masrytechn.model.UserModel.loggedInUser;

public class UserViewModel extends ViewModel {


    private MutableLiveData<LoginResponse> loginResponse = new MutableLiveData<>();


    private MutableLiveData<Boolean> companyLogin = new MutableLiveData<>();
    private MutableLiveData<Boolean> companyLogOut = new MutableLiveData<>();

    private MutableLiveData<Boolean> logout = new MutableLiveData<>();
    private MutableLiveData<Boolean> userLogin = new MutableLiveData<>();


    public MutableLiveData<LoginResponse> makeLogin() {
        return loginResponse;
    }

    public void loginToServer(final Context context, String username,
                              String password) {

        LoginRequest request = new LoginRequest();
//        request.setUsername(username);
//        request.setLang(lang);
//        request.setPassword(password);
//        request.setToken(new FireBaseToken().getToken());

        UserRepository.getInstance().loginRepository(request).subscribe(new Observer<LoginResponse>() {
            @Override
            public void onSubscribe(Disposable d) {
            }

            @Override
            public void onNext(LoginResponse value) {


                loginResponse.postValue(value);
            }

            @Override
            public void onError(Throwable e) {

                loginResponse.postValue(null);

            }

            @Override
            public void onComplete() {

            }
        });
    }


    public MutableLiveData<Boolean> checkUSerIfLogin() {
        return userLogin;
    }

    public void checkUser(final Context context) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    UserModel userData = DataBase.getInstance(context).userProfileDao().checkIfUserExist();
                    if (userData != null) {
                        loggedInUser = userData;
                        userLogin.postValue(true);

                    } else {
                        userLogin.postValue(false);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                    userLogin.postValue(false);
                }


            }
        }).start();

    }

    public MutableLiveData<Boolean> makeLogout() {
        return logout;
    }

    public void setLogout(final Context context) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    DataBase.getInstance(context).userProfileDao().clear();
                    logout.postValue(true);

                } catch (Exception ex) {
                    ex.printStackTrace();
                    logout.postValue(false);
                }


            }
        }).

                start();

    }


    private void saveDataInDataBase(Context context, String email, String name, String phone,
                                    String location, String image, String accessToken, int type,
                                    int id, int loginType) {

        UserModel userData = new UserModel();
        userData.setLoginType(loginType);
        userData.setRefreshToken(accessToken);
        userData.setEmail(email);
        userData.setUserName(name);
        userData.setPhone(phone);
        userData.setImageUrl(image);
        userData.setLocation(location);
        userData.setActive(1);
        userData.setUserType(type);
        userData.setId(id);
        loggedInUser = userData;
        DataBase.getInstance(context).userProfileDao().insert(loggedInUser);

    }


    private void updateDataInDataBase(final Context context, String email, String name, String location, String phone) {
        loggedInUser.setLocation(location);
        loggedInUser.setUserName(name);
        loggedInUser.setEmail(email);
        loggedInUser.setPhone(phone);
        DataBase.getInstance(context).userProfileDao().updateUserDate(loggedInUser);
    }


}
