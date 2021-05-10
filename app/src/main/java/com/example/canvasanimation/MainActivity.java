package com.example.canvasanimation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    Activity_Animation002_Layout animation002_layout_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        animation002_layout_view = new Activity_Animation002_Layout(this);
        setContentView(animation002_layout_view); //this uses the view from the java class instead of layot xml

    }

    @Override
    protected void onPause() {

        super.onPause();

        animation002_layout_view.pause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        animation002_layout_view.resume();
    }
}