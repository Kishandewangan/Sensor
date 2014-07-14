package com.apeiron.earlylossdetector;

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
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ScrollView;
import android.widget.TextView;

public class EmergencyContacts extends Activity  {
	
		public Context context;
		/*SensorManager senSensorManager;
		  Sensor senAccelerometer;*/
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
		
			
			System.out.println("Reached Community reg screen");
			
			ScrollView sv=new ScrollView(this);
			sv.setHorizontalScrollBarEnabled(true);
			sv.setVerticalScrollBarEnabled(true);
			
			LinearLayout regLayout=new LinearLayout(this);
			LayoutParams lp=new LayoutParams(LinearLayout.LayoutParams.FILL_PARENT,LinearLayout.LayoutParams.FILL_PARENT);
			regLayout.setLayoutParams(lp);
			regLayout.setOrientation(LinearLayout.VERTICAL);
			
			
			
			LayoutParams childViewParams=new LayoutParams(LinearLayout.LayoutParams.FILL_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT);
			sv.setLayoutParams(lp);
			
			
			
			TextView headerTExt=new TextView(this);
			headerTExt.setText("Add emergency Contacts");
			headerTExt.setTextSize(20f);
			headerTExt.setLayoutParams(childViewParams);
			headerTExt.setTextColor(Color.RED);
			headerTExt.setGravity(Gravity.CENTER);
			regLayout.addView(headerTExt);
			
			
			TextView text1=new TextView(this);
			text1.setText("Contact 1");
			text1.setTextSize(18f);
			text1.setLayoutParams(childViewParams);
			//text1.setTextColor(Color.RED);
			regLayout.addView(text1);
			
			final EditText emr_contact_1=new EditText(this);
			emr_contact_1.setLayoutParams(childViewParams);
			regLayout.addView(emr_contact_1);
			
			emr_contact_1.setInputType(InputType.TYPE_CLASS_NUMBER);
			
			
			
			
			TextView text2=new TextView(this);
			text2.setText("Contact 2");
			text2.setTextSize(18f);
			text2.setLayoutParams(childViewParams);
			//text1.setTextColor(Color.RED);
			regLayout.addView(text2);
			
			final EditText emr_contact_2=new EditText(this);
			emr_contact_2.setLayoutParams(childViewParams);
			regLayout.addView(emr_contact_2);
			emr_contact_2.setInputType(InputType.TYPE_CLASS_NUMBER);
			
			
			
			
			TextView text3=new TextView(this);
			text3.setText("Contact 3");
			text3.setTextSize(18f);
			text3.setLayoutParams(childViewParams);
			//text1.setTextColor(Color.RED);
			regLayout.addView(text3);
						
			final EditText emr_contact_3=new EditText(this);
			emr_contact_3.setLayoutParams(childViewParams);
			regLayout.addView(emr_contact_3);
			emr_contact_3.setInputType(InputType.TYPE_CLASS_NUMBER);
			
			
			
			
			
			
			TextView text4=new TextView(this);
			text4.setText("Contact 4");
			text4.setTextSize(18f);
			text4.setLayoutParams(childViewParams);
			//text1.setTextColor(Color.RED);
			regLayout.addView(text4);
						
			final EditText emr_contact_4=new EditText(this);
			emr_contact_4.setLayoutParams(childViewParams);
			regLayout.addView(emr_contact_4);
			emr_contact_4.setInputType(InputType.TYPE_CLASS_NUMBER);
			
			
			
			
			
			

			TextView text5=new TextView(this);
			text5.setText("Contact 5");
			text5.setTextSize(18f);
			text5.setLayoutParams(childViewParams);
			//text1.setTextColor(Color.RED);
			regLayout.addView(text5);
						
			final EditText emr_contact_5=new EditText(this);
			emr_contact_5.setLayoutParams(childViewParams);
			regLayout.addView(emr_contact_5);
			emr_contact_5.setInputType(InputType.TYPE_CLASS_NUMBER);
			
			
			
			
			Button b=new Button(this);
			b.setText("Add");
			b.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					System.out.println("Validating Text....");
					
					
					if(emr_contact_1.getText().toString().compareToIgnoreCase("")==0)
					{

						AlertDialog alertDialog1 = new AlertDialog.Builder(
								EmergencyContacts.this).create();
			 
			            // Setting Dialog Title
			            alertDialog1.setTitle("Error!!!");
			 
			            // Setting Dialog Message
			            alertDialog1.setMessage("Please add atleast one Emergency Contact Number!!");
			 
			            // Setting Icon to Dialog
			           // alertDialog1.setIcon(R.drawable.tick);
			 
			            // Setting OK Button
			            alertDialog1.setButton("OK", new DialogInterface.OnClickListener() {
			 
			                public void onClick(DialogInterface dialog, int which) {
			                    // Write your code here to execute after dialog
			                    // closed
			               /*     Toast.makeText(getApplicationContext(),
			                            "You clicked on OK", Toast.LENGTH_SHORT).show();*/
			                } 
			            });
			 
			            // Showing Alert Message
			            alertDialog1.show();
						
					}
					else
					{
						System.out.println("Reached else part..");
						//Add DB Data
						Toast.makeText(EmergencyContacts.this, "Sucessfully added emergency contact numbers", Toast.LENGTH_SHORT).show();
				         Intent i=new Intent(getBaseContext(),EarlyLostSettings.class);
		                    startActivity(i);
		                     
		                    //Remove activity
		             // SplashScreen.class.finish();
		                    EmergencyContacts.this.finish();
		                     
						
					}
				}
			});
			
			
			regLayout.addView(b);
			sv.addView(regLayout);
			
			
			setContentView(sv);
			
		}
		

}
