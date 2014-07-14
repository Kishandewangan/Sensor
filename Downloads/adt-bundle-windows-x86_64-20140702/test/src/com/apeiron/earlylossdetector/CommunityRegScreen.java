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
import android.widget.LinearLayout.LayoutParams;
import android.widget.ScrollView;
import android.widget.TextView;

public class CommunityRegScreen extends Activity  {
	
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
			headerTExt.setText("Community Registration");
			headerTExt.setTextSize(20f);
			headerTExt.setLayoutParams(childViewParams);
			headerTExt.setTextColor(Color.RED);
			headerTExt.setGravity(Gravity.CENTER);
			regLayout.addView(headerTExt);
			
			
			TextView text1=new TextView(this);
			text1.setText("Peer 1");
			text1.setTextSize(18f);
			text1.setLayoutParams(childViewParams);
			//text1.setTextColor(Color.RED);
			regLayout.addView(text1);
			
			final EditText peer1_contact_no=new EditText(this);
			peer1_contact_no.setLayoutParams(childViewParams);
			regLayout.addView(peer1_contact_no);
			peer1_contact_no.setInputType(InputType.TYPE_CLASS_NUMBER);
			
			
			
			
			TextView text2=new TextView(this);
			text2.setText("Peer 2");
			text2.setTextSize(18f);
			text2.setLayoutParams(childViewParams);
			//text1.setTextColor(Color.RED);
			regLayout.addView(text2);
			
			final EditText peer2_contact_no=new EditText(this);
			peer2_contact_no.setLayoutParams(childViewParams);
			regLayout.addView(peer2_contact_no);
			peer2_contact_no.setInputType(InputType.TYPE_CLASS_NUMBER);
			
			
			
			
			TextView text3=new TextView(this);
			text3.setText("Peer 3");
			text3.setTextSize(18f);
			text3.setLayoutParams(childViewParams);
			//text1.setTextColor(Color.RED);
			regLayout.addView(text3);
						
			final EditText peer3_contact_no=new EditText(this);
			peer3_contact_no.setLayoutParams(childViewParams);
			regLayout.addView(peer3_contact_no);
			peer3_contact_no.setInputType(InputType.TYPE_CLASS_NUMBER);
			
			
			
			
			
			
			TextView text4=new TextView(this);
			text4.setText("Peer 4");
			text4.setTextSize(18f);
			text4.setLayoutParams(childViewParams);
			//text1.setTextColor(Color.RED);
			regLayout.addView(text4);
						
			final EditText peer4_contact_no=new EditText(this);
			peer4_contact_no.setLayoutParams(childViewParams);
			regLayout.addView(peer4_contact_no);
			peer4_contact_no.setInputType(InputType.TYPE_CLASS_NUMBER);
			
			
			
			
			
			

			TextView text5=new TextView(this);
			text5.setText("Peer 5");
			text5.setTextSize(18f);
			text5.setLayoutParams(childViewParams);
			//text1.setTextColor(Color.RED);
			regLayout.addView(text5);
						
			final EditText peer5_contact_no=new EditText(this);
			peer5_contact_no.setLayoutParams(childViewParams);
			regLayout.addView(peer5_contact_no);
			peer5_contact_no.setInputType(InputType.TYPE_CLASS_NUMBER);
			
			
			
			
			Button b=new Button(this);
			b.setText("Add");
			b.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					System.out.println("Validating Text....");
					
					
					if(peer1_contact_no.getText().toString().compareToIgnoreCase("")==0)
					{

						AlertDialog alertDialog1 = new AlertDialog.Builder(
			                    CommunityRegScreen.this).create();
			 
			            // Setting Dialog Title
			            alertDialog1.setTitle("Error!!!");
			 
			            // Setting Dialog Message
			            alertDialog1.setMessage("Please add atleast one Peer Contact Number!!");
			 
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
				         Intent i=new Intent(getBaseContext(),EarlyLostSettings.class);
		                    startActivity(i);
		                     
		                    //Remove activity
		             // SplashScreen.class.finish();
		                    CommunityRegScreen.this.finish();
		                     
						
					}
				}
			});
			
			
			regLayout.addView(b);
			sv.addView(regLayout);
			
			
			setContentView(sv);
			
		}
		

}
