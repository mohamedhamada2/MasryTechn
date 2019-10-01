package com.nglah.masrytechn.view.nglah_location;

import android.os.Bundle;

import com.nglah.masrytechn.R;

import androidx.appcompat.app.AppCompatActivity;

public class nglah_location extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nglah_location);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
