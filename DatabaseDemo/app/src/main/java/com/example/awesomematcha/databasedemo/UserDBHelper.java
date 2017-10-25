package com.example.awesomematcha.databasedemo;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
/**
 * Created by Awesome Matcha on 14-Jun-17.
 */
    public class UserDBHelper extends SQLiteOpenHelper{
    private static final String DB_NAME="training";
    private static final int DB_VERSION=1;
    private static final String TABLE_NAME="users";
    private static final String COL_1="id";
    private static final String COL_2="name";
    private static final String COL_3="email";
    private static final String COL_4="phone";
    private static final String Query="CREATE TABLE " + TABLE_NAME + "(" + COL_1 + " INTEGER PRIMARY KEY AUTOINCREMENT," + COL_2 + " TEXT," +
            COL_3 + " TEXT," + COL_4 + " TEXT)";
    public UserDBHelper(Context context){
        super(context,DB_NAME,null,DB_VERSION);
        Log.i("Database Message:", "Database created successfully");
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Query);
        Log.i("Database Message:", "Table has been created successfully");
    }
    public boolean InsertData(String name,String email,String phone,SQLiteDatabase db){
        ContentValues content=new ContentValues();
        content.put(COL_2,name);
        content.put(COL_3,email);
        content.put(COL_4,phone);
        db.insert(TABLE_NAME,null,content);
        return true;
    }
    public Cursor getAllData(SQLiteDatabase db){
        Cursor cursor=db.rawQuery("SELECT * FROM " + TABLE_NAME,null);
        return cursor;
    }
    public Cursor searchData(SQLiteDatabase db,String name){
        Cursor cursor=db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE " + COL_2 + " LIKE " + "'" + name + "'" , null);
        return cursor;
    }
    public int updateData(SQLiteDatabase db, int id,String name,String email,String phone){
        ContentValues content=new ContentValues();
        content.put(COL_2,name);
        content.put(COL_3,email);
        content.put(COL_4,phone);
        String[] whereArgs=new String[]{String.valueOf(id)};
        int numRows=db.update(TABLE_NAME, content,"id=?",whereArgs);
        return numRows;
    }
    public int deleteData(SQLiteDatabase db, int id){
        String[] whereArgs=new String[]{String.valueOf(id)};
        int numRows=db.delete(TABLE_NAME, "id=?",whereArgs);
        return numRows;
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}