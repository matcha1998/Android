package com.example.awesomematcha.mytraining;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn,btns;
    EditText email,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=(Button)findViewById(R.id.btn);
        email=(EditText)findViewById(R.id.email);
        btns=(Button)findViewById(R.id.btns);
        password=(EditText)findViewById(R.id.password);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(email.getText().toString().equals("xyz@mywbut.com") && password.getText().toString().equals("1234"))
                    Toast.makeText(MainActivity.this,"You are Welcome!",Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(MainActivity.this,"Incorrect Login!",Toast.LENGTH_LONG).show();
            }
        });
        btns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"Welcome to my App!!",Toast.LENGTH_LONG).show();
            }
        });
    }
}
