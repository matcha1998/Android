package com.example.awesomematcha.databaselogin;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class LoginActivity extends AppCompatActivity {
    TextView res1,res2,res3,res4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Bundle bundle=getIntent().getExtras();
        res2=(TextView)findViewById(R.id.res2);
        res3=(TextView)findViewById(R.id.res3);
        res4=(TextView)findViewById(R.id.res4);
        String r2=bundle.getString("Name");
        res2.setText("Name:" + r2);
        String r3=bundle.getString("Email");
        res3.setText("Email:" + r3);
        String r4=bundle.getString("Phone");
        res4.setText("Phone No:" + r4);
    }
}
