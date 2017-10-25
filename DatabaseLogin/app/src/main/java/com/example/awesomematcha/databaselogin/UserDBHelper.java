package com.example.awesomematcha.databaselogin;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Awesome Matcha on 19-Jun-17.
 */

public class UserDBHelper extends SQLiteOpenHelper {
    private static final String DB_NAME="college";
    private static final int    DB_VERSION=1;
    private static final String TABLE_NAME="students";
    private static final String COL_1="id";
    private static final String COL_2="name";
    private static final String COL_3="email";
    private static final String COL_4="phone";
    private static final String COL_5="password";
    private static final String QUERY="CREATE TABLE " + TABLE_NAME + "(" + COL_1 + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + COL_2 + " TEXT," + COL_3 + " TEXT," + COL_4 + " TEXT," + COL_5 + " TEXT)";
    public UserDBHelper(Context context){
        super(context,DB_NAME,null,DB_VERSION);
        Log.i("Database Message:", "Database created successfully");
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(QUERY);
        Log.i("Database Message:","Table has been created successfully");
    }
    public boolean InsertData(String name,String email,String phone,String password,SQLiteDatabase db){
        ContentValues content=new ContentValues();
        content.put(COL_2,name);
        content.put(COL_3,email);
        content.put(COL_4,phone);
        content.put(COL_5,password);
        db.insert(TABLE_NAME,null,content);
        return true;
    }
    public Cursor getData(SQLiteDatabase db){
        Cursor cursor=db.rawQuery("SELECT * FROM " + TABLE_NAME ,null);
        return cursor;
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
