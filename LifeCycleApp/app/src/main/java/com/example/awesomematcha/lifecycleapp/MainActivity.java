package com.example.awesomematcha.lifecycleapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
public class MainActivity extends AppCompatActivity {
    private static final String TAG="MyCustomMessage";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG,"This is OnCreate");
    }

    @Override
    protected void onStart() {
        Log.i(TAG, "This is OnStart");
        super.onStart();
    }

    @Override
    protected void onRestart() {
        Log.i(TAG, "This is ReStart");
        super.onRestart();
    }

    @Override
    protected void onResume() {
        Log.i(TAG,"This is OnResume");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.i(TAG,"This is OnPause");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.i(TAG,"This is OnStop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.i(TAG, "This is Destroy");
        super.onDestroy();
    }
}