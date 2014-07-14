package com.apeiron.earlylossdetector;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;

public class EarlyLostSettings extends Activity implements OnClickListener {
	
	public static final int addEmergencyContacts=1;
	public static final int addSafeLocations=2;
	
	public static final int addSensorSettings=3;
	public static final int startSensors=4;
	public static final int stopSensors=5;
	public Context context;
	/*SensorManager senSensorManager;
	  Sensor senAccelerometer;*/
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		context=getApplicationContext();
		LinearLayout settingsLayout=new LinearLayout(this);
	
		LayoutParams lp=new LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
		settingsLayout.setLayoutParams(lp);
		settingsLayout.setOrientation(LinearLayout.VERTICAL);
		LayoutParams childViewParams=new LayoutParams(LinearLayout.LayoutParams.FILL_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT);
		
		

		
		TextView headerTExt=new TextView(this);
		headerTExt.setText("Settings");
		headerTExt.setTextSize(20f);
		headerTExt.setLayoutParams(childViewParams);
		headerTExt.setTextColor(Color.RED);
		headerTExt.setGravity(Gravity.CENTER);
		settingsLayout.addView(headerTExt);
		
		
		Button addECN=new Button(this);
		addECN.setText("Add Emegency Contact Numbers");
		addECN.setLayoutParams(childViewParams);
		addECN.setId(addEmergencyContacts);
		addECN.setOnClickListener(this);
		
		
		
		
		Button SetGeolocations=new Button(this);
		SetGeolocations.setText("Add SAFE Location zones");
		SetGeolocations.setLayoutParams(childViewParams);
		SetGeolocations.setId(addSafeLocations);
		SetGeolocations.setOnClickListener(this);
		
		Button sensorSettings=new Button(this);
		sensorSettings.setText("Sensor Settings");
		sensorSettings.setLayoutParams(childViewParams);
		sensorSettings.setId(addSensorSettings);
		sensorSettings.setOnClickListener(this);
		
		Button startSensor=new Button(this);
		startSensor.setText("Start Sensor");
		startSensor.setLayoutParams(childViewParams);
		startSensor.setId(startSensors);
		startSensor.setOnClickListener(this);
		
		Button stopSensor=new Button(this);
		stopSensor.setText("Stop Sensor");
		stopSensor.setLayoutParams(childViewParams);
		stopSensor.setId(stopSensors);
		stopSensor.setOnClickListener(this);
		
		settingsLayout.addView(addECN);		
		settingsLayout.addView(SetGeolocations);
		settingsLayout.addView(sensorSettings);
		

		settingsLayout.addView(startSensor);		
		settingsLayout.addView(stopSensor);
		
		
	setContentView(settingsLayout);
		
		
	}
	@Override
	 public void onClick(View v) {
		
		System.out.println("VIEW CLICKED and VIEW ID IS..."+v.getId());
		 StartAction sa1=new StartAction(context);
        switch (v.getId()) {
      
        
        case addEmergencyContacts:
            Toast.makeText(getApplicationContext(), "Add Emergencycontacts is clicked" + "+", Toast.LENGTH_SHORT).show(); 
            Intent i=new Intent(getBaseContext(),EmergencyContacts.class);
            startActivity(i);
             
            //Remove activity
     // SplashScreen.class.finish();
            EarlyLostSettings.this.finish();
             
            
            
            break;
        case  addSafeLocations:
            Toast.makeText(getApplicationContext(),"Add SAFE locations is clicked" + "-", Toast.LENGTH_SHORT).show();
            break;
            
        case  addSensorSettings:
            Toast.makeText(getApplicationContext(),"Add Sensor Settings is clicked" + "-", Toast.LENGTH_SHORT).show();
            Intent sensoractivity=new Intent(getBaseContext(),SensorSettings.class);
            startActivity(sensoractivity);
             
            //Remove activity
     // SplashScreen.class.finish();
            EarlyLostSettings.this.finish();
             
            break;
        case  startSensors:
        	Toast.makeText(getApplicationContext(),"Add Sensor Settings is clicked" + "-", Toast.LENGTH_SHORT).show();
            //StartAction sa1=new StartAction(context);
            sa1.startSensors();
             
            break;
            
        case  stopSensors:
        	Toast.makeText(getApplicationContext(),"Add Sensor Settings is clicked" + "-", Toast.LENGTH_SHORT).show();
            //StartAction sa2=new StartAction(context);
            sa1.stopSensors();
            //Remove activity
     // SplashScreen.class.finish();
             
            break;
            
        default:
            break;
        }
    }
}
