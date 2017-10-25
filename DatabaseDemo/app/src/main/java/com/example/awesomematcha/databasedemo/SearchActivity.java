package com.example.awesomematcha.databasedemo;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SearchActivity extends AppCompatActivity {
    Button searchBtn;
    EditText searchInput;
    TextView searchResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        searchBtn=(Button)findViewById(R.id.searchBtn);
        searchInput=(EditText)findViewById(R.id.nameInputSearch);
        searchResult=(TextView)findViewById(R.id.searchResult);
        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if(searchInput.getText().toString().equals(""))
                   Toast.makeText(SearchActivity.this,"Empty Field!!", Toast.LENGTH_SHORT).show();
               else {
                   UserDBHelper userdbhelper = new UserDBHelper(SearchActivity.this);
                   SQLiteDatabase db = userdbhelper.getReadableDatabase();
                   Cursor cursor = userdbhelper.searchData(db, searchInput.getText().toString());
                   if (cursor.getCount() == 0)
                       searchResult.setText("No User Found");
                   else {
                       cursor.moveToFirst();
                       StringBuffer sbuffer = new StringBuffer();
                       do {
                           sbuffer.append("Name: " + cursor.getString(1) + "\n");
                           sbuffer.append("Email: " + cursor.getString(2) + "\n");
                           sbuffer.append("Phone: " + cursor.getString(3) + "\n\n\n\n");
                       } while (cursor.moveToNext());
                       searchResult.setText(sbuffer.toString());
                   }
               }
            }
        });
    }
}
