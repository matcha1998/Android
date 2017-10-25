package com.example.awesomematcha.resumemaker;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static android.R.attr.name;

/**
 * Created by Matcha on 07-Jul-17.
 */

public class UserDbHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "User_Resume";
    private static final int DB_VER = 1;

    private static final String TABLE_NAME = "USER_INFO";
    private static final String COL_1 = "ID";
    private static final String COL_2 = "FULL_NAME";
    private static final String COL_3 = "DOB";
    private static final String COL_4 = "EMAIL_ADDRESS";
    private static final String COL_5 = "PHONE";
    private static final String COL_6 = "RESIDENTIAL_ADDRESS";
    private static final String COL_7 = "BOARD_NAME_TENTH";
    private static final String COL_8 = "MARKS_TENTH";
    private static final String COL_9 = "BOARD_NAME_TWELVE";
    private static final String COL_10 = "MARKS_TWELVE";
    private static final String COL_11 = "COLLEGE_NAME";
    private static final String COL_12 = "COLLEGE_COURSE_NAME";
    private static final String COL_13 = "PASS_OUT_YEAR";
    private static final String COL_14 = "CGPA";
    private static final String COL_15 = "WORK_EXPERIENCE";
    private static final String COL_16 = "SCHOLASTIC_ACHIEVEMENTS";
    private static final String COL_17 = "POSITION_OF_RESPONSIBILITY";
    private static final String COL_18 = "STRENGTHS_AND_WEAKNESSES";

    private static final String QUERY = "CREATE TABLE " + TABLE_NAME + " (" + COL_1 +

            " INTEGER PRIMARY KEY AUTOINCREMENT," + COL_2 + " TEXT," + COL_3 + " TEXT," +

            COL_4 + " TEXT," + COL_5 + " TEXT," + COL_6 + " TEXT," +

            COL_7 + " TEXT," + COL_8 + " TEXT," +

            COL_9 + " TEXT," + COL_10 + " TEXT," +

            COL_11 + " TEXT," + COL_12 + " TEXT," + COL_13 +

            " TEXT," + COL_14 + " TEXT," + COL_15 + " TEXT," +

            COL_16 + " TEXT," + COL_17 + " TEXT," + COL_18 +

            " TEXT)";



    public UserDbHelper(Context context) {

        super(context, DB_NAME, null, DB_VER);

    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(QUERY);
    }

    public boolean saveData(SQLiteDatabase db, String name, String date, String email, String phone, String address,
                            String board_10th, String marks_10th, String board_12th, String marks_12th, String college,
                            String college_course, String passoutYear, String cgpa,String works,String sa, String por, String sw) {
        ContentValues content = new ContentValues();
        content.put(COL_2, name);
        content.put(COL_3, date);
        content.put(COL_4, email);
        content.put(COL_5, phone);
        content.put(COL_6, address);
        content.put(COL_7, board_10th);
        content.put(COL_8, marks_10th);
        content.put(COL_9, board_12th);
        content.put(COL_10, marks_12th);
        content.put(COL_11, college);
        content.put(COL_12, college_course);
        content.put(COL_13, passoutYear);
        content.put(COL_14, cgpa);
        content.put(COL_15, works);
        content.put(COL_16, sa);
        content.put(COL_17, por);
        content.put(COL_18, sw);
        db.insert(TABLE_NAME, null, content);

        return true;
    }


    public Cursor getAll(SQLiteDatabase db, String email) {

        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE " + COL_4 +
                " LIKE " + "'" + email + "'", null);

        return cursor;
    }

    public int deleteData(SQLiteDatabase db, int id) {
        String[] whereArgs = new String[] {String.valueOf(id)};

        int row_num = db.delete(TABLE_NAME, "id=?", whereArgs);

        return row_num;
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
