package com.example.awesomematcha.resumemaker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ViewActivity extends AppCompatActivity {
    EditText email;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        email=(EditText)findViewById(R.id.view_email);
        btn=(Button)findViewById(R.id.view_Btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(ViewActivity.this,ViewResumeCV.class);
                i.putExtra("email",email.getText().toString());
                startActivity(i);
            }
        });
    }
}
