package com.apeiron.earlylossdetector;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ScrollView;

public class NewHome extends Activity implements OnClickListener{
	ImageButton start1;
	ImageButton stop1;
	ImageButton community;
	ImageButton emergency;
	ImageButton locations;
	ImageButton sensorsettings;
	ImageButton about;
	StartAction sa;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);

    requestWindowFeature(Window.FEATURE_NO_TITLE);
    System.out.println("loading..");
    setContentView(R.layout.home);
    
    /*LinearLayout parent=new LinearLayout(this);
	LayoutParams lp=new LayoutParams(LinearLayout.LayoutParams.FILL_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT);
	parent.setLayoutParams(lp);
	parent.setOrientation(LinearLayout.VERTICAL);
	
    RelativeLayout header=(RelativeLayout) findViewById(R.layout.header);
    LinearLayout home=(LinearLayout) findViewById(R.layout.home);
    */

    //get all the image buttons objects..
    sa=new StartAction(getBaseContext());
    start1= (ImageButton) findViewById(R.id.imageButton1);
    stop1= (ImageButton) findViewById(R.id.imageButton2);
    community= (ImageButton) findViewById(R.id.imageButton3);
    emergency= (ImageButton) findViewById(R.id.imageButton4);
    locations= (ImageButton) findViewById(R.id.imageButton5);
    sensorsettings= (ImageButton) findViewById(R.id.imageButton6);
    about= (ImageButton) findViewById(R.id.imageButton7);
    
    System.out.println("Start 1 id..."+start1.getId());
    //button3.setOnClickListener(onClickListener); Enable OnClick lister  below class
    start1.setOnClickListener(this);
    stop1.setOnClickListener(this);
    community.setOnClickListener(this);
    emergency.setOnClickListener(this);
    locations.setOnClickListener(this);
    sensorsettings.setOnClickListener(this);
    about.setOnClickListener(this);
	//l.addView(l1);
   
    
	}

	@Override
	public void onClick(View v) {
		switch(v.getId()){
        case R.id.imageButton1:
             //DO something
        	System.out.println("....Clicking on Start Button");
        	
        	sa.startSensors();
        break;
        
        case R.id.imageButton2:
             //DO something
        	System.out.println("....Clicking on Stop Button");
        	sa.stopSensors();
        break;
        
        case R.id.imageButton3:
             //Community Page should appear here...
        	System.out.println("....Clicking on Community Button");
        	
        	Community c=new Community(getBaseContext());
        	ScrollView cc=c.getCommunity();
        	setContentView(cc);
        	        break;
        
        case R.id.imageButton4:
             //DO something
        	System.out.println("....Clicking on ECI  Button");
        	NewEmerGency emergency=new NewEmerGency(getBaseContext());
        	ScrollView sc=NewEmerGency.getEmergency();
        	setContentView(sc);
        	
        break;
      
        case R.id.imageButton5:
             //DO something
        	System.out.println("....Clicking on Location Button");
        	break;
        
        case R.id.imageButton6:
             //DO something
        	System.out.println("....Clicking on Settings Button");
        break;
        
        case R.id.imageButton7:
            //DO something
        	System.out.println("....Clicking on about  Button");
       break;
	}
	
/*	private OnClickListener onClickListener = new OnClickListener() {
	     @Override
	     public void onClick(View v) {
	         switch(v.getId()){
	             case R.id.button1:
	                  //DO something
	             break;
	             case R.id.button2:
	                  //DO something
	             break;
	             case R.id.button3:
	                  //DO something
	             break;
	         }

	   }
	};*/
	}
}

