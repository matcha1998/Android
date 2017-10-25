package com.example.awesomematcha.databasedemo;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static android.R.attr.password;

public class InsertActivity extends AppCompatActivity {
    EditText name,email,phone;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);
        name=(EditText)findViewById(R.id.nameInputInsert);
        email=(EditText)findViewById(R.id.emailInputInsert);
        phone=(EditText)findViewById(R.id.phoneInputInsert);
        btn=(Button)findViewById(R.id.btnInsert);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(name.getText().toString().equals("")&&email.getText().toString().equals("")&&phone.getText().toString().equals(""))
                    Toast.makeText(InsertActivity.this,"No valid data entered!!",Toast.LENGTH_LONG).show();
                   else{
                    UserDBHelper userdbhelper = new UserDBHelper(InsertActivity.this);
                    SQLiteDatabase db = userdbhelper.getWritableDatabase();
                    boolean response = userdbhelper.InsertData(name.getText().toString(), email.getText().toString(),
                            phone.getText().toString(),db);
                    if (response == true)
                        Toast.makeText(InsertActivity.this, "Data Inserted", Toast.LENGTH_LONG).show();
                    else
                        Toast.makeText(InsertActivity.this, "Some error occurred while Insertion", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}