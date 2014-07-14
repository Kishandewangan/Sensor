package com.apeiron.earlylossdetector;


import java.util.Date;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorListener;
import android.hardware.SensorManager;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;

@SuppressLint("NewApi")
public class StartAction implements SensorEventListener {

	private SensorManager senSensorManager;
    private Sensor senAccelerometer;
    private long lastUpdate=System.currentTimeMillis();
    private float last_x, last_y, last_z;
    private static final int SHAKE_THRESHOLD = 30;
    private long lastShake=System.currentTimeMillis();
  //  private long currentTime;
    public static boolean sensor_started=true;
    
    /** Called when the activity is first created. */
    public Context context;
 
    public StartAction(Context context)
    {
    	this.context=context;
       // setContentView(R.layout.main);
    	System.out.println("Is context is nulll.."+context);
      
     
    }

   
    
    public void stopSensors()
   
    {
    	System.out.println("Setting senror state to falses....current sensor value ..."+sensor_started);
    	
    	
    	
    	if(StartAction.sensor_started==true||StartAction.sensor_started==false)
    	{
    		
    		System.out.println("In Stop sensor....");
    		StartAction.sensor_started=false;
        		
    		System.out.println("SensorManage is null....");
    		Toast.makeText(context, "Services not started", Toast.LENGTH_SHORT).show();
    //		senSensorManager.unregisterListener(this);
    		senSensorManager.unregisterListener(StartAction.this);
    	///	senSensorManager.flush(StartAction.this);
    		
    		System.out.println("");
    	}
    	else
    	{
    		System.out.println("Stopping Sensor Listeners...");
    		//senSensorManager.unregisterListener(StartAction.this);
    	//	senSensorManager.unregisterListener(this);
    		senSensorManager.unregisterListener(StartAction.this);
    	//	senSensorManager.flush(StartAction.this);
    		//senSensorManager.unregisterListener(StartAction.this, Sensor.TYPE_ACCELEROMETER);        	
    		
    		senAccelerometer=null;
    		//senSensorManager.unregisterListener((SensorListener) context);

    		//senSensorManager.unregisterListener(NewHome.class);
    		senSensorManager=null;
    	}
    	
    }
    
    public void startSensors()
    
    {
    	sensor_started=true;
    	lastUpdate=System.currentTimeMillis();
    	lastShake=System.currentTimeMillis();
    	MyDB mm=new MyDB(context);
    	if(senSensorManager==null)
    	{
    	  senSensorManager = (SensorManager) context.getSystemService(Context.SENSOR_SERVICE);
    	}
    	if(senAccelerometer==null)
    	{
    	  senAccelerometer = senSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
    	}
    	boolean is_enrolled=mm.isenrolled();
    	System.out.println("Device is enrolled or not..."+is_enrolled);
    	if(is_enrolled==true)
    	{

    		if(senSensorManager==null)
    		{
    			 senAccelerometer = senSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
    		     
    		}
        senSensorManager.registerListener(this, senAccelerometer , SensorManager.SENSOR_DELAY_NORMAL);
    
    	}
    	else
    	{
    		Toast.makeText(context, "You should atleast one Community and Emergency contact number before starting!!", Toast.LENGTH_LONG).show();
    	}
    }
    

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        //To change body of implemented methods use File | Settings | File Templates.
        
    	Sensor mySensor = sensorEvent.sensor;
  
        System.out.println(",,,,,check sensor started or not...."+sensor_started);
        
        if(StartAction.sensor_started==false)
        {
        	
        	
        System.out.println("Sensor not started yet..");	
        Toast.makeText(context, "Not started", Toast.LENGTH_SHORT).show();
        
        }
        
        
        
        else
        {
        if (mySensor.getType() == Sensor.TYPE_ACCELEROMETER) {
        	
        	if(sensor_started==true)
        	{
            float x = sensorEvent.values[0];
            float y = sensorEvent.values[1];
            float z = sensorEvent.values[2];
          //  System.out.println("Getting the sensor values.....");

            long curTime = System.currentTimeMillis();
            // only allow one update every 1seconds.
          
            if ((curTime - lastUpdate) > 1000) {
            	System.out.println("Every 10 seconds we are collecting the values..");
                long diffTime = (curTime - lastUpdate);
                lastUpdate = curTime;
                System.out.println("Got the difference then check..Shake Detection!!....diff time"+diffTime);

                float speed = Math.abs(x+y+z - last_x - last_y - last_z)/ diffTime * 10000;
                System.out.println("Check the threshold values....");
               // System.out.println("Last Shake Detected at..."+lastShake);
                
              	if(speed > 300)
        		{
        			
        			System.out.println("Device fallen showing alert....");
        			/*Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        			Ringtone r = RingtoneManager.getRingtone(context, notification);
        			r.play();*/
        			notifyUser();
        		}
                
                if (speed >=SHAKE_THRESHOLD) {
                    Toast.makeText(context, "shake detected w/ speed: " + speed, Toast.LENGTH_SHORT).show();
                    lastShake = new Date().getTime();
                     //System.out.println("Shake Detected at..."+lastShake);
                }
          
                else
                	if(speed < SHAKE_THRESHOLD)
                	{
                		long now=new Date().getTime();
                		
                		System.out.println("Last Shake detected at.."+lastShake);
                		//System.out.println("Current Date and time..."+currentTime);
                		//System.out.println("Difference in timings..."+(currentTime-lastShake));
                		
                		System.out.println("Calculation difference in the times...in Seconds..."+(curTime-lastShake)/1000);
                		
                		//We are getting the differences in milliseconds then converting into seconds (/1000). so again coverting into min(1000*60)
                		if((now-lastShake)/60000>=1)
                		{
                			
                			System.out.println("device in ideal stateNeed to show warning....");
                			/*Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
                			
                			Ringtone r = RingtoneManager.getRingtone(context, notification);
                			r.play();*/
                			notifyUser();
                			
                		}
                		
                	
                	}
                                
                last_x = x;
                last_y = y;
                last_z = z;
            }
         
        	}
        }
        }
    
        
    }

    @Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
		// can be safely ignored for this demo
	}
    
    public void notifyUser(){
    	 
     NotificationManager notificationManager = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
     
        Intent intent=new Intent(context, NewHome.class);
         //Define sound URI
      Uri soundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE);
      
        //use the flag FLAG_UPDATE_CURRENT to override any notification already there
        PendingIntent contentIntent = PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
     
        Notification notification = new Notification(R.drawable.ic_launcher, "Some Text", System.currentTimeMillis());
       // notification.flags = Notification.FLAG_AUTO_CANCEL | Notification.DEFAULT_LIGHTS |Notification.DEFAULT_SOUND | Notification.DEFAULT_ALL;
     
        notification.flags =  Notification.FLAG_AUTO_CANCEL | Notification.DEFAULT_ALL;
        
        
        notification.setLatestEventInfo(context, "Is Device Fallen??", "Please touch your device once..", contentIntent);
        //10 is a random number I chose to act as the id for this notification
        notificationManager.notify(10, notification);
     
    	
    	 //on Notification click launching the app
       /* Intent intent=new Intent(context, NewHome.class);
         PendingIntent contentIntent = PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
         
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

      
          
      
      Intent notificationIntent = new Intent(context, NewHome.class);
      PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, notificationIntent, 0);
     
      NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context)
              .setSmallIcon(R.drawable.plus1)
              .setContentTitle("Device Fallen?")
              .setContentText("Tap to Dismiss")
              .setSound(soundUri)
              .setContentIntent(pendingIntent)
              .setAutoCancel(true);
      
     
      //Display notification
      notificationManager.notify(1, mBuilder.build());
      */

        
        
    }

}