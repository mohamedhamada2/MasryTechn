package com.nglah.masrytechn.view.login;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;

import com.nglah.masrytechn.R;
import com.nglah.masrytechn.network.networkModel.login.LoginResponse;
import com.nglah.masrytechn.view.forgetPassword.ForgetActivity;
import com.nglah.masrytechn.view.main.MainActivity;
import com.nglah.masrytechn.view.register.RegisterActivity;
import com.nglah.masrytechn.view.util.CheckNetwork;
import com.nglah.masrytechn.viewModel.UserViewModel;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.username)
    EditText et_userName;
    @BindView(R.id.password)
    EditText et_password;
    @BindView(R.id.btn_next)
    Button btn_login;
    @BindView(R.id.forget)
    TextView tv_forget;
    @BindView(R.id.textView4)
    TextView tv_createAccount;

    @BindString(R.string.noUserName)
    String noUserName;
    @BindString(R.string.noPassword)
    String noPassword;
    UserViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        initListener();
    }


    private void initListener() {

        viewModel = ViewModelProviders.of(this).get(UserViewModel.class);
        viewModel.makeLogin().observe(this, new Observer<LoginResponse>() {
            @Override
            public void onChanged(LoginResponse loginResponse) {
                //
                goToMain();

            }
        });

    }

    private Boolean checkData() {
        if (TextUtils.isEmpty(et_userName.getText().toString())) {
            et_userName.setText(noUserName);
            return false;

        } else if (TextUtils.isEmpty(et_password.getText().toString())) {
            et_password.setText(noPassword);
            return false;
        } else {
            return true;
        }

    }

    @OnClick(R.id.btn_next)
    void login() {

        if (checkData()) {

            if (new CheckNetwork(this).getConnected()){

                viewModel.loginToServer(this,et_userName.getText().toString(),
                        et_password.getText().toString());

            }
        }
    }


    @OnClick(R.id.textView4)
    void createAccount() {
        startActivity(new Intent(this, RegisterActivity.class));
    }

    @OnClick(R.id.forget)
    void forgetPassword() {
        startActivity(new Intent(this, ForgetActivity.class));
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    private void goToMain(){

        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}
