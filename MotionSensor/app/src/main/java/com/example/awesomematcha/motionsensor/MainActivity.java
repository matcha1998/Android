package com.example.awesomematcha.motionsensor;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements SensorEventListener {
    TextView x, y, z;
    Sensor mySensor;
    SensorManager sm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        x = (TextView) findViewById(R.id.x);
        y = (TextView) findViewById(R.id.y);
        z = (TextView) findViewById(R.id.z);
        sm=(SensorManager)getSystemService(SENSOR_SERVICE);
        mySensor=sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sm.registerListener(MainActivity.this,mySensor,SensorManager.SENSOR_DELAY_NORMAL);
    }
    public void onSensorChanged(SensorEvent event){
        x.setText("x: "+ event.values[0]);
        y.setText("y: "+ event.values[1]);
        z.setText("z: "+ event.values[2]);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}