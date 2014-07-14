package com.apeiron.earlylossdetector;

import java.util.Date;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.widget.LinearLayout.LayoutParams;

@SuppressLint("NewApi")
public class SensorEventsManager extends Activity implements SensorEventListener {

	private SensorManager senSensorManager;
    private Sensor senAccelerometer;
    private long lastUpdate;
    private float last_x, last_y, last_z;
    private static final int SHAKE_THRESHOLD = 60;
    private long lastShake;
    private long currentTime;
    /** Called when the activity is first created. */
    @SuppressLint("NewApi")
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.main);
        senSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        senAccelerometer = senSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        senSensorManager.registerListener(this, senAccelerometer , SensorManager.SENSOR_DELAY_NORMAL);
//        for (int i = 0; i < lotteryNumbers.size(); i++) {
//             Log.i("LOG", " @@@@@@@@" + lotteryNumbers.get(i));
//        }
     /*   LinearLayout l=new LinearLayout(this);
        LayoutParams lp=new LayoutParams(LinearLayout.LayoutParams.FILL_PARENT,LinearLayout.LayoutParams.FILL_PARENT);
		l.setLayoutParams(lp);
		l.setOrientation(LinearLayout.VERTICAL);
		
		LayoutParams childViewParams=new LayoutParams(LinearLayout.LayoutParams.FILL_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT);
		Button b1=new Button(this);
		b1.setText("Stop Sensors");
		b1.setLayoutParams(childViewParams);	
		b1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				System.out.println("Stopping  Sensora....");
				//Toast.makeText(getApplicationContext(), "Sensor code should go from here!!", Toast.LENGTH_SHORT);
			//	SensorCode s=new SensorCode(this,senSensorManager);
				Intent myIntent = new Intent(SensorEventsManager.this, MainActivity.class);
				//myIntent.putExtra("key", value); //Optional parameters
				SensorEventsManager.this.startActivity(myIntent);
			}
		});
		setContentView(l);
        
        */
    }

    protected void onResume() {
        super.onResume();
       // senSensorManager.registerListener(this, senAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);
    }

    protected void onPause() {
        super.onPause();
        //senSensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        //To change body of implemented methods use File | Settings | File Templates.
        Sensor mySensor = sensorEvent.sensor;

        if (mySensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            float x = sensorEvent.values[0];
            float y = sensorEvent.values[1];
            float z = sensorEvent.values[2];
            System.out.println("Getting the sensor values.....");

            long curTime = System.currentTimeMillis();
            // only allow one update every 100ms.
            if ((curTime - lastUpdate) > 100) {
                long diffTime = (curTime - lastUpdate);
                lastUpdate = curTime;
                System.out.println("Got the difference then check..Shake Detection!!");

                float speed = Math.abs(x+y+z - last_x - last_y - last_z)/ diffTime * 10000;
                System.out.println("Check the threshold values....");
                System.out.println("Last Shake Detected at..."+lastShake);
                if (speed > SHAKE_THRESHOLD) {
                    Toast.makeText(this, "shake detected w/ speed: " + speed, Toast.LENGTH_SHORT).show();
                    lastShake = new Date().getTime();
                     //System.out.println("Shake Detected at..."+lastShake);
                }
                currentTime=new Date().getTime();
                if(currentTime-lastShake>=40000)
                {
                	
                	System.out.println("Current TIme...."+currentTime);
                	System.out.println("lastShake TIme...."+lastShake);
                	System.out.println("Not moving....");
                	Toast.makeText(this, "Not Moving..", Toast.LENGTH_SHORT).show();
                }
                
                last_x = x;
                last_y = y;
                last_z = z;
            }
            else
            {
            	System.out.println("Is it reaching else block or not???");
            	currentTime=new Date().getTime();
            	System.out.println("Current Time....."+currentTime);
            	Toast.makeText(this, "Waited for 30 seconds there is no changes", Toast.LENGTH_SHORT).show();
            	
            }
        }
    }

    @Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
		// can be safely ignored for this demo
	}


}