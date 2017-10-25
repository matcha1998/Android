package com.example.awesomematcha.resumemaker;

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

public class DeleteActivity extends AppCompatActivity {
    EditText emailDel,idDel;
    Button delBtn,getIDBtn;
    TextView result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
        emailDel=(EditText)findViewById(R.id.del_email);
        idDel=(EditText)findViewById(R.id.del_id);
        delBtn=(Button)findViewById(R.id.delBtn);
        getIDBtn=(Button)findViewById(R.id.getIDBtn);
        result=(TextView)findViewById(R.id.delResult);
        getIDBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserDbHelper userdbhelper = new UserDbHelper(DeleteActivity.this);
                SQLiteDatabase db = userdbhelper.getReadableDatabase();
                Cursor cursor = userdbhelper.getAll(db, emailDel.getText().toString());
                if (cursor.getCount() != 0){
                    cursor.moveToFirst();
                StringBuffer sb = new StringBuffer();
                do {
                    sb.append("Your ID is: " + cursor.getString(0));
                } while (cursor.moveToNext());
                result.setText(sb.toString());
            }
            else{
                    Toast.makeText(DeleteActivity.this, "ID not Found!!\nEnter proper Email ID", Toast.LENGTH_SHORT).show();
                }
            }
        });
        delBtn.setOnClickListener(new View.OnClickListener() {
            UserDbHelper userdbhelper = new UserDbHelper(DeleteActivity.this);
            SQLiteDatabase db = userdbhelper.getReadableDatabase();
            @Override
            public void onClick(View v) {
                int id=Integer.parseInt(idDel.getText().toString());
                int row_num=userdbhelper.deleteData(db,id);
                if(row_num>0)
                    Toast.makeText(DeleteActivity.this,"Your Resume has been deleted successfully!!",Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(DeleteActivity.this,"Some error occurred!!",Toast.LENGTH_LONG).show();
            }
        });
    }
}
