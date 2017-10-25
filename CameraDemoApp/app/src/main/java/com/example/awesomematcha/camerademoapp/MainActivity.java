package com.example.awesomematcha.camerademoapp;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    Button btn;
    ImageView container;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=(Button)findViewById(R.id.btn);
        container=(ImageView) findViewById(R.id.container);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                File file=getFile();
                intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(file));
                startActivityForResult(intent,1);
            }
        });
    }
    private File getFile(){
        File folder=new File("sdcard/camerademo");
        if(!folder.exists())
            folder.mkdir();
        File image_file=new File(folder,"camera_output_image.jpg");
        return image_file;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        String path="sdcard/camerademo/camera__OUTPUT_image.jpg";
        container.setImageDrawable(Drawable.createFromPath(path));
    }
}