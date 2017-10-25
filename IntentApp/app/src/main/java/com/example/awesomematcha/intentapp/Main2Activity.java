package com.example.awesomematcha.intentapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    TextView res1,res2,res3,res4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Bundle bundle=getIntent().getExtras();
        res1=(TextView)findViewById(R.id.res1);
        res2=(TextView)findViewById(R.id.res2);
        res3=(TextView)findViewById(R.id.res3);
        res4=(TextView)findViewById(R.id.res4);
        String r1=bundle.getString("name");
        res1.setText("Name: " + r1);
        String r2=bundle.getString("email");
        res2.setText("Email: " + r2);
        String r3=bundle.getString("password");
        res3.setText("password: " + r3);
        String r4=bundle.getString("gender");
        res4.setText("Gender: " + r4);
    }
}