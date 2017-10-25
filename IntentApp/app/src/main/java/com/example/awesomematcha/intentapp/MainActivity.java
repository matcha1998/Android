package com.example.awesomematcha.intentapp;

import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText name,email,password;
    RadioGroup rg;
    RadioButton rb;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name=(EditText)findViewById(R.id.name);
        btn=(Button)findViewById(R.id.btn);
        rg=(RadioGroup)findViewById(R.id.rg);
        email=(EditText)findViewById(R.id.email);
        password=(EditText)findViewById(R.id.password);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,Main2Activity.class);
                int a=rg.getCheckedRadioButtonId();
                rb=(RadioButton)findViewById(a);
                i.putExtra("name",name.getText().toString());
                i.putExtra("email",email.getText().toString());
                i.putExtra("password",password.getText().toString());
                i.putExtra("gender",rb.getText().toString());

                startActivity(i);
            }
        });
    }
}
