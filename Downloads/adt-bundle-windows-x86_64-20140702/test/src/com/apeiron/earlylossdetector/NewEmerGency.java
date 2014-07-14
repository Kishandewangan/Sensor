package com.apeiron.earlylossdetector;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Application;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.InputType;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ScrollView;
import android.widget.TextView;

public class NewEmerGency
{
	
		public static Context context;
		/*SensorManager senSensorManager;
		  Sensor senAccelerometer;*/
		/*SensorManager senSensorManager;
		  Sensor senAccelerometer;*/
		
	public NewEmerGency(Context context)
		{
			this.context=context;
		    System.out.println("Reached Community reg screen");
		}
		public static ScrollView getEmergency()
		{
				
				final ScrollView sv=new ScrollView(context);
				sv.setHorizontalScrollBarEnabled(true);
				sv.setVerticalScrollBarEnabled(true);
				final LinearLayout regLayout=new LinearLayout(context);
				LayoutParams lp=new LayoutParams(LinearLayout.LayoutParams.FILL_PARENT,LinearLayout.LayoutParams.FILL_PARENT);
				regLayout.setLayoutParams(lp);
				regLayout.setOrientation(LinearLayout.VERTICAL);
				
				
				final LayoutParams childViewParams=new LayoutParams(LinearLayout.LayoutParams.FILL_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT);
				final LayoutParams childViewParams2=new LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
				
				sv.setLayoutParams(lp);
				
				View v=LayoutInflater.from(context).inflate(R.layout.newheader, null);
				regLayout.addView(v);
				
				TextView headerTExt=new TextView(context);
				headerTExt.setText("Add emergency Contacts");
				headerTExt.setTextSize(20f);
				headerTExt.setLayoutParams(childViewParams);
				headerTExt.setTextColor(Color.RED);
				headerTExt.setGravity(Gravity.CENTER);
				regLayout.addView(headerTExt);
				
				
				TextView text1=new TextView(context);
				text1.setText("Contact 1");
				text1.setTextSize(18f);
				text1.setLayoutParams(childViewParams);
				//text1.setTextColor(Color.RED);
				regLayout.addView(text1);
				
				final EditText emr_contact_1=new EditText(context);
				emr_contact_1.setLayoutParams(childViewParams);
				regLayout.addView(emr_contact_1);
				
				emr_contact_1.setInputType(InputType.TYPE_CLASS_NUMBER);
				
				
				
				
				TextView text2=new TextView(context);
				text2.setText("Contact 2");
				text2.setTextSize(18f);
				text2.setLayoutParams(childViewParams);
				//text1.setTextColor(Color.RED);
				regLayout.addView(text2);
				
				final EditText emr_contact_2=new EditText(context);
				emr_contact_2.setLayoutParams(childViewParams);
				regLayout.addView(emr_contact_2);
				emr_contact_2.setInputType(InputType.TYPE_CLASS_NUMBER);
				
				
				
				
				TextView text3=new TextView(context);
				text3.setText("Contact 3");
				text3.setTextSize(18f);
				text3.setLayoutParams(childViewParams);
				//text1.setTextColor(Color.RED);
				regLayout.addView(text3);
							
				final EditText emr_contact_3=new EditText(context);
				emr_contact_3.setLayoutParams(childViewParams);
				regLayout.addView(emr_contact_3);
				emr_contact_3.setInputType(InputType.TYPE_CLASS_NUMBER);
				

				Button b=new Button(context);
				b.setText("Add");
				b.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						System.out.println("Validating Text....");
						
						if(emr_contact_1.getText().toString().equalsIgnoreCase("")&&emr_contact_2.getText().toString().equalsIgnoreCase("")&&emr_contact_3.getText().toString().equalsIgnoreCase(""))
						{
							
							Toast.makeText(context, "Please add atleast one emergency contact numbers", Toast.LENGTH_SHORT).show();
						}
						
					/*	Dailog not working so adding toast message only
					 * if(emr_contact_1.getText().toString().compareToIgnoreCase("")==0)
						{

							AlertDialog alertDialog1 = new AlertDialog.Builder(
									context.getApplicationContext()).create();
				 
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
				                    Toast.makeText(getApplicationContext(),
				                            "You clicked on OK", Toast.LENGTH_SHORT).show();
				                } 
				            });
				 
				            // Showing Alert Message
				            alertDialog1.show();
							
						}*/
						else
						{
							System.out.println("Reached else part..");
							
							MyDB mm=new MyDB(context);
					
							if(emr_contact_1.getText().toString().equalsIgnoreCase("")==false)
							{
							int em_1=Integer.parseInt(emr_contact_1.getText().toString());
							mm.insertinto_emergency_contacts(em_1);
							}
							
							if(emr_contact_2.getText().toString().equalsIgnoreCase("")==false)
							{
							int em_2=Integer.parseInt(emr_contact_2.getText().toString());
							mm.insertinto_emergency_contacts(em_2);
							}
							
							if(emr_contact_3.getText().toString().equalsIgnoreCase("")==false)
							{
							int em_3=Integer.parseInt(emr_contact_3.getText().toString());
							mm.insertinto_emergency_contacts(em_3);
							}
							
							//Add DB Data
							Toast.makeText(context, "Sucessfully added emergency contact numbers", Toast.LENGTH_SHORT).show();
							Intent i=new Intent(context, NewHome.class);
							i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
							context.startActivity(i);
							
						}
					}
				});
				
				
				regLayout.addView(b);
				
				sv.addView(regLayout);
				sv.setBackgroundColor(Color.DKGRAY);
				return sv;
				
			
			
		
		}
}
