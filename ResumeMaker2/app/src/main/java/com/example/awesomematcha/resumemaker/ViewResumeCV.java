package com.example.awesomematcha.resumemaker;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class ViewResumeCV extends AppCompatActivity {
    TextView res1,res2,res3,res4,res5,res6,res7,res8,res9,res10,res11,res12,res13,res14,res15,res16,res17;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_resume_cv);
        res1=(TextView)findViewById(R.id.res1);
        res2=(TextView)findViewById(R.id.res2);
        res3=(TextView)findViewById(R.id.res3);
        res4=(TextView)findViewById(R.id.res4);
        res5=(TextView)findViewById(R.id.res5);
        res6=(TextView)findViewById(R.id.res6);
        res7=(TextView)findViewById(R.id.res7);
        res8=(TextView)findViewById(R.id.res8);
        res9=(TextView)findViewById(R.id.res9);
        res10=(TextView)findViewById(R.id.res10);
        res11=(TextView)findViewById(R.id.res11);
        res12=(TextView)findViewById(R.id.res12);
        res13=(TextView)findViewById(R.id.res13);
        res14=(TextView)findViewById(R.id.res14);
        res15=(TextView)findViewById(R.id.res15);
        res16=(TextView)findViewById(R.id.res16);
        res17=(TextView)findViewById(R.id.res17);
        Bundle bundle = getIntent().getExtras();
        String email = bundle.getString("email");
        UserDbHelper userdbhelper=new UserDbHelper(ViewResumeCV.this);
        SQLiteDatabase db=userdbhelper.getReadableDatabase();
        Cursor cursor=userdbhelper.getAll(db,email);
        if(cursor.getCount()!=0){
            cursor.moveToFirst();
                res1.setText("Name:" + cursor.getString(1));
                res2.setText("Date of Birth:" + cursor.getString(2));
                res3.setText("Email:" + cursor.getString(3));
                res4.setText("Phone:" + cursor.getString(4));
                res5.setText("Residential Address:" + cursor.getString(5));
                res6.setText("Class 10 Board:" + cursor.getString(6));
                res7.setText("Class 10 Marks:" + cursor.getString(7));
                res8.setText("Class 12 Board:" + cursor.getString(8));
                res9.setText("Class 12 Marks:" + cursor.getString(9));
                res10.setText("Name of College:" + cursor.getString(10));
                res11.setText("Course Name:" + cursor.getString(11));
                res12.setText("Year of Passing :" + cursor.getString(12));
                res13.setText("CGPA:" + cursor.getString(13));
                res14.setText(cursor.getString(14));
                res15.setText("Scholastic Achievements:" + cursor.getString(15));
                res16.setText("Position of Responsibility:" + cursor.getString(16));
                res17.setText("Strengths and Weaknesses:" + cursor.getString(17));

        }
        else{
            Toast.makeText(ViewResumeCV.this,"Invalid Email Id \n(OR)\nYou have not created your Resume",Toast.LENGTH_LONG).show();
        }

    }
}
