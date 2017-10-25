package com.example.awesomematcha.checkbox;

import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    CheckBox ch1,ch2,ch3;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ch1=(CheckBox)findViewById(R.id.ch1);
        ch2=(CheckBox)findViewById(R.id.ch2);
        ch3=(CheckBox)findViewById(R.id.ch3);
        btn=(Button)findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,ch1.getText().toString()+"\t"+ch1.isChecked()+"\n"+ch2.getText().toString()+"\t"+ch2.isChecked()+"\n"+ch3.getText().toString()+"\t"+ch3.isChecked(),Toast.LENGTH_LONG).show();
            }
        });
    }
}
