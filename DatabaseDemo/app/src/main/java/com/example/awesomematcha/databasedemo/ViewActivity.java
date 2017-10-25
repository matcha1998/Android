package com.example.awesomematcha.databasedemo;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.StringDef;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ViewActivity extends AppCompatActivity {
    TextView result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        result=(TextView)findViewById(R.id.retrieveData);
        UserDBHelper userdbhelper=new UserDBHelper(ViewActivity.this);
        SQLiteDatabase db=userdbhelper.getReadableDatabase();
        Cursor cursor=userdbhelper.getAllData(db);
        if(cursor.getCount()==0)
            result.setText("There is no user in the DataBase");
        else
        {
            cursor.moveToFirst();
            StringBuffer sbuffer=new StringBuffer();
            do{
                sbuffer.append("Name: " + cursor.getString(1) + "\n");
                sbuffer.append("Email: " + cursor.getString(2) + "\n");
                sbuffer.append("Phone: " + cursor.getString(3) + "\n\n\n\n");
            }while(cursor.moveToNext());
            result.setText(sbuffer.toString());
        }
    }
}
