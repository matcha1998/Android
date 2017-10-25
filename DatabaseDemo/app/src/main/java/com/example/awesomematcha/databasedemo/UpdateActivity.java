package com.example.awesomematcha.databasedemo;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateActivity extends AppCompatActivity {
    EditText upId,upName,upEmail,upPhone;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        upId=(EditText)findViewById(R.id.idInputUpdate);
        upName=(EditText)findViewById(R.id.nameInputUpdate);
        upEmail=(EditText)findViewById(R.id.emailInputUpdate);
        upPhone=(EditText)findViewById(R.id.phoneInputUpdate);
        btn=(Button)findViewById(R.id.updateBtn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(upId.getText().toString().equals(""))
                    Toast.makeText(UpdateActivity.this,"Empty Field",Toast.LENGTH_LONG).show();
                else {
                    UserDBHelper userdbhelper = new UserDBHelper(UpdateActivity.this);
                    SQLiteDatabase db = userdbhelper.getWritableDatabase();
                    int id = Integer.parseInt(upId.getText().toString());
                    int numRows = userdbhelper.updateData(db, id, upName.getText().toString(), upEmail.getText().toString(), upPhone.getText().toString());
                    if (numRows > 0)
                        Toast.makeText(UpdateActivity.this, "Updation Successful", Toast.LENGTH_SHORT).show();
                    else {
                        Toast.makeText(UpdateActivity.this, "Some Error Occurred", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
