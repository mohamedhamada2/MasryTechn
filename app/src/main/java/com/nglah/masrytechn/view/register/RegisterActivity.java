package com.nglah.masrytechn.view.register;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;

import com.nglah.masrytechn.R;
import com.nglah.masrytechn.viewModel.UserViewModel;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;

public class RegisterActivity extends AppCompatActivity {

    @BindView(R.id.usernamel)
    EditText et_userName;
    @BindView(R.id.password)
    EditText et_password;
    @BindView(R.id.phonel)
    EditText et_phone;
    @BindView(R.id.email)
    EditText et_email;
    @BindView(R.id.btn_next)
    Button btn_register;

    @BindString(R.string.noUserName)
    String noUserName;
    @BindString(R.string.noPassword)
    String noPassword;
    @BindString(R.string.noPhone)
    String noPhone;
    @BindString(R.string.noEmail)
    String noEmail;

    UserViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
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


}
