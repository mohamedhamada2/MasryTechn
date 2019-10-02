package com.nglah.masrytechn.view.Choose_City;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.nglah.masrytechn.R;

public class Choose_City extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose__city);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("قم باختيار المدينة");
    }
}
