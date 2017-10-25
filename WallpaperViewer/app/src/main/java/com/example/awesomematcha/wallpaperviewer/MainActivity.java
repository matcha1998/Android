package com.example.awesomematcha.wallpaperviewer;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView image;
    Button btn;
    int counter=0;
    int[] arr={R.drawable.cr,R.drawable.rk,R.drawable.rohit,R.drawable.two};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        image=(ImageView)findViewById(R.id.image);
        btn=(Button)findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter++;
                if(counter>4){
                    counter=1;
                    image.setImageResource(arr[0]);
                }
                image.setImageResource(arr[counter-1]);

            }
        });
    }
}
