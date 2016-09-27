package com.rscottcarson.activeandroid_tutorial.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.rscottcarson.activeandroid_tutorial.R;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


}
