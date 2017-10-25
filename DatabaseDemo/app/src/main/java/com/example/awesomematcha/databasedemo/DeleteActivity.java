package com.example.awesomematcha.databasedemo;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DeleteActivity extends AppCompatActivity {
    Button deleteBtn;
    EditText deleteInput;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
        deleteBtn=(Button)findViewById(R.id.deleteBtn);
        deleteInput=(EditText)findViewById(R.id.idInputDelete);
        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(deleteInput.getText().toString().equals(""))
                    Toast.makeText(DeleteActivity.this,"Empty Field",Toast.LENGTH_LONG).show();
                else {
                    UserDBHelper userdbhelper = new UserDBHelper(DeleteActivity.this);
                    SQLiteDatabase db = userdbhelper.getWritableDatabase();
                    int id = Integer.parseInt(deleteInput.getText().toString());
                    int numRows = userdbhelper.deleteData(db, id);
                    if (numRows > 0)
                        Toast.makeText(DeleteActivity.this, "Deletion Successful", Toast.LENGTH_SHORT).show();
                    else {
                        Toast.makeText(DeleteActivity.this, "Some Error Occurred", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
