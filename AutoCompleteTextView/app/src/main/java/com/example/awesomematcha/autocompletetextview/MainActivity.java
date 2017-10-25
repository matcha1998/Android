package com.example.awesomematcha.autocompletetextview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class MainActivity extends AppCompatActivity {
    String[] Country={"INDIA","PAKISTAN","SRILANKA","SOUTHAFRICA","ENGLAND","AUSTRALIA","NEWZEALAND","BANGLADESH","WESTINDIES","PORTUGAL","ARGENTINA","BRAZIL","RUSSIA","ITALY"};
    AutoCompleteTextView auto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        auto=(AutoCompleteTextView)findViewById(R.id.auto);
        ArrayAdapter adapter=new ArrayAdapter(MainActivity.this,android.R.layout.select_dialog_item,Country);
        auto.setAdapter(adapter);

    }
}
