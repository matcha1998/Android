package com.example.awesomematcha.databaselogin;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText emailLogin, passwordLogin;
    Button loginBtn, registerBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        emailLogin = (EditText) findViewById(R.id.emailLogin);
        passwordLogin = (EditText) findViewById(R.id.passwordLogin);
        loginBtn = (Button) findViewById(R.id.loginBtn);
        registerBtn = (Button) findViewById(R.id.registerBtn);

                loginBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        UserDBHelper userdbhelper = new UserDBHelper(MainActivity.this);
                        SQLiteDatabase db = userdbhelper.getReadableDatabase();
                        Cursor cursor = userdbhelper.getData(db);
                        if (cursor.getCount() == 0)
                            Toast.makeText(MainActivity.this, "Entered Email or Password is Incorrect\n(OR)\nYou have not registered yet!!"
                                    , Toast.LENGTH_LONG).show();
                        else {
                            int flag=0;
                            cursor.moveToFirst();
                            Intent i=new Intent(MainActivity.this,LoginActivity.class);
                            StringBuffer sbuffer = new StringBuffer();
                            do {
                                if (emailLogin.getText().toString().equals(cursor.getString(2)) &&
                                        passwordLogin.getText().toString().equals(cursor.getString(4))){
                                    i.putExtra("Name",cursor.getString(1));
                                    i.putExtra("Email",cursor.getString(2));
                                    i.putExtra("Phone",cursor.getString(3));
                                    startActivity(i);
                                    flag=1;
                                }

                            } while (cursor.moveToNext());
                            if(flag==0)
                                Toast.makeText(MainActivity.this, "Entered Email or Password is Incorrect\n(OR)" +
                                                "\nYou have not registered yet!!"
                                        ,Toast.LENGTH_LONG).show();
                        }
                    }
                });
            registerBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i=new Intent(MainActivity.this,RegisterActivity.class);
                    startActivity(i);
                }
            });
        }
    }