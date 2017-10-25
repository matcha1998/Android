package com.example.awesomematcha.resumemaker;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static android.R.attr.duration;

public class CreateActivity extends AppCompatActivity {
    EditText name, date, email, phone, address, board_tenth, marks_tenth, board_12, marks_12, college, course,
            year, cgpa, work, sa, por, sw;
    Button save;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
        name = (EditText)findViewById(R.id.name);
        date = (EditText)findViewById(R.id.date);
        email = (EditText)findViewById(R.id.emailID);
        phone = (EditText)findViewById(R.id.phone);
        address = (EditText)findViewById(R.id.res_Add);
        board_tenth = (EditText)findViewById(R.id.board_tenth);
        marks_tenth = (EditText)findViewById(R.id.marks_tenth);
        board_12 = (EditText)findViewById(R.id.board_12);
        marks_12 = (EditText)findViewById(R.id.marks_12);
        college = (EditText)findViewById(R.id.college);
        course = (EditText)findViewById(R.id.course);
        year = (EditText)findViewById(R.id.year);
        cgpa = (EditText)findViewById(R.id.cgpa);
        work = (EditText)findViewById(R.id.work);
        sa=(EditText)findViewById(R.id.sca);
        por=(EditText)findViewById(R.id.por);
        sw=(EditText)findViewById(R.id.sandw);

        save = (Button)findViewById(R.id.saveBtn);


        save.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                if(name.getText().toString().equals("") || date.getText().toString().equals("") ||
                        email.getText().toString().equals("") || phone.getText().toString().equals("") ||
                        address.getText().toString().equals("") ||marks_tenth.getText().toString().equals("") ||
                        marks_12.getText().toString().equals("") || college.getText().toString().equals("") ||
                        course.getText().toString().equals("") ||
                        cgpa.getText().toString().equals("")||
                        sa.getText().toString().equals("") ||
                        por.getText().toString().equals("") ||
                        sw.getText().toString().equals("")) {

                    Toast.makeText(CreateActivity.this, "* marked fields are Mandatory!!\nPlease fill those fields!!", Toast.LENGTH_LONG).show();
                }
                else {
                    UserDbHelper userdbhelper=new UserDbHelper(CreateActivity.this);
                    SQLiteDatabase db=userdbhelper.getWritableDatabase();
                    boolean response = userdbhelper.saveData(db, name.getText().toString(), date.getText().toString(),
                            email.getText().toString(), phone.getText().toString(), address.getText().toString(),
                            board_tenth.getText().toString(),marks_tenth.getText().toString(),
                            board_12.getText().toString(),marks_12.getText().toString(),
                            college.getText().toString(), course.getText().toString(),
                            year.getText().toString(),cgpa.getText().toString(), work.getText().toString(),
                            sa.getText().toString(),por.getText().toString(), sw.getText().toString());

                    if (response == true) {
                        Toast.makeText(CreateActivity.this, "Your data has been saved successfully!!", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(CreateActivity.this, "some error occurred", Toast.LENGTH_SHORT).show();
                    }

                    /*name.setText("");
                    emailID.setText("");
                    date.setText("");
                    phone.setText("");
                    address.setText("");
                    board_tenth.setText("");
                    marks_tenth.setText("");
                    board_12.setText("");
                    marks_12.setText("");
                    college.setText("");
                    course.setText("");
                    year.setText("");
                    cgpa.setText("");
                    work.setText("");
                    sa.setText("");
                    por.setText("");
                    sw.setText("");*/
                }

            }
        });
    }
}