package com.apeiron.earlylossdetector;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.InputType;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ScrollView;
import android.widget.TextView;

public class SensorSettings extends Activity  {
	
		public Context context;
		/*SensorManager senSensorManager;
		  Sensor senAccelerometer;*/
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
		
			
			System.out.println("Reached Community reg screen");
			
		
			
			LinearLayout sensrosettingslayout=new LinearLayout(this);
			LayoutParams lp=new LayoutParams(LinearLayout.LayoutParams.FILL_PARENT,LinearLayout.LayoutParams.FILL_PARENT);
			sensrosettingslayout.setLayoutParams(lp);
			sensrosettingslayout.setOrientation(LinearLayout.VERTICAL);
			
			
			
			LayoutParams childViewParams=new LayoutParams(LinearLayout.LayoutParams.FILL_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT);
		
			
			
			
			TextView headerTExt=new TextView(this);
			headerTExt.setText("Sensor Settings");
			headerTExt.setTextSize(20f);
			headerTExt.setLayoutParams(childViewParams);
			headerTExt.setTextColor(Color.RED);
			headerTExt.setGravity(Gravity.CENTER);
			sensrosettingslayout.addView(headerTExt);
			
			TextView text2=new TextView(this);
			text2.setText("InActivity Timer");
			text2.setTextSize(18f);
			text2.setLayoutParams(childViewParams);
			//text1.setTextColor(Color.RED);
			sensrosettingslayout.addView(text2);
			
			
			
			 final Spinner spinner = new Spinner(this);
				List<String> list = new ArrayList<String>();
				list.add("10");
				list.add("15");
				list.add("20");
				list.add("25");
				
				
				  ArrayAdapter spinnerArrayAdapter = new ArrayAdapter(this,
					        android.R.layout.simple_spinner_dropdown_item,
					          list);
					    spinner.setAdapter(spinnerArrayAdapter);
					    
					    
				//ArrayAdapter dd= new ArrayAdapter<>(this, 122, list);
				
				spinner.setLayoutParams(childViewParams);
				sensrosettingslayout.addView(spinner);
				
			
			Button b=new Button(this);
			b.setText("SAVE");
			b.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					System.out.println("Validating Text....");
					
					
					
						System.out.println("Reached else part..");
						//Add DB Data
						Toast.makeText(SensorSettings.this, "Sucessfully saved Settings", Toast.LENGTH_SHORT).show();
				         Intent i=new Intent(getBaseContext(),EarlyLostSettings.class);
		                    startActivity(i);
		                     
		                    //Remove activity
		             // SplashScreen.class.finish();
		                    SensorSettings.this.finish();
		                     
						
					}
				
			});
			
			
			sensrosettingslayout.addView(b);
		
			setContentView(sensrosettingslayout);
			
		}
		

}
