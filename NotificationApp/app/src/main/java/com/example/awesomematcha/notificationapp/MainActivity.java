package com.example.awesomematcha.notificationapp;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button notify;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        notify=(Button)findViewById(R.id.notify);
        notify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationCompat.Builder notification=new NotificationCompat.Builder(MainActivity.this);
                notification.setAutoCancel(true);
                notification.setSmallIcon(R.drawable.cr);
                notification.setTicker("Ye aa notification");
                notification.setContentTitle("Heading");
                notification.setContentText("Content of Notification");
                Intent i=new Intent(MainActivity.this,MainActivity.class);
                PendingIntent pi=PendingIntent.getActivity(MainActivity.this,0,i,PendingIntent.FLAG_UPDATE_CURRENT);
                notification.setContentIntent(pi);
                NotificationManager nm=(NotificationManager)getSystemService(NOTIFICATION_SERVICE);
                nm.notify(234,notification.build());
            }
        });
    }
}
