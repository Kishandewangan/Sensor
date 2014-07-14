package com.apeiron.earlylossdetector;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.LinearLayout.LayoutParams;

public class SplashScreen extends Activity {

	String tag="EarlyLossDetector";
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		
		super.onCreate(savedInstanceState);
	
		      Log.d(tag, "Launching Splash Screen");
		      requestWindowFeature(Window.FEATURE_NO_TITLE);
		        
		        LinearLayout l=new LinearLayout(this);
				LayoutParams lp=new LayoutParams(LinearLayout.LayoutParams.FILL_PARENT,LinearLayout.LayoutParams.FILL_PARENT);
				l.setLayoutParams(lp);
				l.setOrientation(LinearLayout.VERTICAL);
				l.setGravity(Gravity.CENTER);
				
				l.setBackgroundColor(Color.parseColor("#EFE4B0"));
				LayoutParams childViewParams=new LayoutParams(LinearLayout.LayoutParams.FILL_PARENT,LinearLayout.LayoutParams.FILL_PARENT);
				
				
		
				
				ImageView iv=new ImageView(this);
				iv.setImageResource(R.drawable.ic_splash);
				
			
				iv.setLayoutParams(childViewParams);
				l.addView(iv);
				
			/*	RelativeLayout rl=new RelativeLayout(this);
				
				//rl.addView(R.layout.homepage);
				
				setContentView(R.layout.header);*/
				
				setContentView(l);
		         
				
				
		// METHOD 1     
		         
		         /****** Create Thread that will sleep for 5 seconds *************/        
		        Thread background = new Thread() {
		            public void run() {
		                 
		                try {
		                	System.out.println("At splash screen ");
		                    // Thread will sleep for 5 seconds
		                    sleep(5*1000);
		                    
		                    
		                    System.out.println("Thread.....launching the new home page");
		                    
		                    // After 5 seconds redirect to another intent
		                    Intent i=new Intent(getBaseContext(),NewHome.class);
		                    startActivity(i);
		                     
		                    //Remove activity
		             // SplashScreen.class.finish();
		                    SplashScreen.this.finish();
		                     
		                } catch (Exception e) {
		                 
		                }
		            }
		        };
		         
		        // start thread
		        background.start();
		         
		//METHOD 2  
		         
		        /*
		        new Handler().postDelayed(new Runnable() {
		              
		            // Using handler with postDelayed called runnable run method
		  
		            @Override
		            public void run() {
		                Intent i = new Intent(MainSplashScreen.this, FirstScreen.class);
		                startActivity(i);
		  
		                // close this activity
		                finish();
		            }
		        }, 5*1000); // wait for 5 seconds
		        */
		    }
		     


}
