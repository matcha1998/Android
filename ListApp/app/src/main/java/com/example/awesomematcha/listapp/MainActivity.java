package com.example.awesomematcha.listapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String[] Country={"INDIA","PAKISTAN","IRAN","AUSTRALIA","PORTUGAL","BRAZIL","CANADA","ARGENTTINA"};
    ListView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list=(ListView)findViewById(R.id.list);
        ArrayAdapter adapter=new ArrayAdapter(MainActivity.this,android.R.layout.select_dialog_item,Country);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String text=list.getItemAtPosition(position).toString();
                Toast.makeText(MainActivity.this,text,Toast.LENGTH_LONG).show();
            }
        });
    }
}
