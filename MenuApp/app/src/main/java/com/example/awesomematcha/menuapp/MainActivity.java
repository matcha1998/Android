package com.example.awesomematcha.menuapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater ourmenu=getMenuInflater();
        ourmenu.inflate(R.menu.main_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        if(id==R.id.about)
            Toast.makeText(MainActivity.this,"This is About",Toast.LENGTH_SHORT).show();
        else if(id==R.id.contact)
            Toast.makeText(MainActivity.this,"This is Contact",Toast.LENGTH_SHORT).show();
        else if(id==R.id.settings)
            Toast.makeText(MainActivity.this,"This is Settings",Toast.LENGTH_SHORT).show();
        return super.onOptionsItemSelected(item);
    }
}
