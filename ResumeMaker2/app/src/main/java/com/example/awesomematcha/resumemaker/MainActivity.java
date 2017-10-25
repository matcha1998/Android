package com.example.awesomematcha.resumemaker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button createResume,viewResume,deleteResume;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createResume = (Button)findViewById(R.id.createBtn);
        viewResume = (Button)findViewById(R.id.viewBtn);
        deleteResume = (Button)findViewById(R.id.deleteBtn);

        createResume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i =new Intent(MainActivity.this,CreateActivity.class);
                startActivity(i);
            }
        });

        viewResume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(MainActivity.this,ViewActivity.class);
                startActivity(i);

            }
        });

        deleteResume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,DeleteActivity.class);
                startActivity(i);
            }
        });
    }
}

