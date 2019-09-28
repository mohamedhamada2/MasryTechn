package com.nglah.masrytechn.view.driver_data;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.nglah.masrytechn.R;

public class Driver_data extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_data);
        getActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
