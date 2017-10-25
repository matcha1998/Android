package com.example.awesomematcha.databaselogin;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    EditText name,email,phone,password;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        name=(EditText)findViewById(R.id.nameRegister);
        email=(EditText)findViewById(R.id.emailRegister);
        phone=(EditText)findViewById(R.id.phoneRegister);
        password=(EditText)findViewById(R.id.passwordRegister);
        btn=(Button)findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(name.getText().toString().equals("")&&email.getText().toString().equals("")
                        &&phone.getText().toString().equals("")&&password.getText().toString().equals(""))
                    Toast.makeText(RegisterActivity.this,"Invalid Data\nEnter some proper Data",Toast.LENGTH_LONG).show();
                else
                {
                    UserDBHelper userdbhelper=new UserDBHelper(RegisterActivity.this);
                    SQLiteDatabase db=userdbhelper.getWritableDatabase();
                    boolean response=userdbhelper.InsertData(name.getText().toString(),email.getText().toString(),phone.getText().toString(),password.getText().toString(),db);
                    if(response==true)
                        Toast.makeText(RegisterActivity.this,"You have registered successfully!!",Toast.LENGTH_LONG).show();
                    else
                        Toast.makeText(RegisterActivity.this,"Some error has occurred\nPlease Try Again!!",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}