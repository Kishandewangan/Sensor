/*package com.apeiron.earlylossdetector;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import android.app.Activity;
import android.app.AlertDialog;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	MyDB mmm;
	public Context context;
	SensorManager senSensorManager;
	  Sensor senAccelerometer;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		createDb(this);
		context =this.getApplicationContext();
		senSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
		 senAccelerometer = senSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
		 mmm=new MyDB(this);

		//String emailID=mmm.getEmailid();
		//System.out.println("Getting the stored GCM ID of the device.."+emailID);
		
		if(mmm.isenrolled()==true)
		{
			System.out.println("XXXX email id is there so navigating to the second screen");
			navigate();

		}
		else
			if(mmm.isenrolled()==false)
			{
				System.out.println("XXXXXX email id is not there so returning to the UI page to enter");
				callUI();
			}	
		
	
		
	}

	private void callUI() {
		// TODO Auto-generated method stub
		
		//setContentView(R.layout.activity_main);
		ScrollView sv=new ScrollView(this);
			
		LinearLayout l=new LinearLayout(this);
		LayoutParams lp=new LayoutParams(LinearLayout.LayoutParams.FILL_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT);
		l.setLayoutParams(lp);
		l.setOrientation(LinearLayout.VERTICAL);
		
		LayoutParams childViewParams=new LayoutParams(LinearLayout.LayoutParams.FILL_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT);
		sv.setLayoutParams(lp);
		
		
		
		TextView headerTExt=new TextView(this);
		headerTExt.setText("Mobile Tracker");
		headerTExt.setTextSize(40f);
		headerTExt.setLayoutParams(childViewParams);
		headerTExt.setTextColor(Color.RED);
		l.addView(headerTExt);
		
		
		TextView text1=new TextView(this);
		text1.setText("What frequency will you move your device?");
		//tv.setTextSize(15f);
		text1.setLayoutParams(childViewParams);
		//text1.setTextColor(Color.RED);
		l.addView(text1);
		
		final EditText device_status=new EditText(this);
		device_status.setLayoutParams(childViewParams);
		l.addView(device_status);
		
		
		 final Spinner spinner = new Spinner(this);
		List<String> list = new ArrayList<String>();
		list.add("1");
		list.add("2");
		list.add("5");
		list.add("10");
		list.add("15");
		list.add("20");
		list.add("30");
		
		
		  ArrayAdapter spinnerArrayAdapter = new ArrayAdapter(this,
			        android.R.layout.simple_spinner_dropdown_item,
			          list);
			    spinner.setAdapter(spinnerArrayAdapter);
			    
			    
		//ArrayAdapter dd= new ArrayAdapter<>(this, 122, list);
		
		spinner.setLayoutParams(childViewParams);
		l.addView(spinner);
		
		
		String freq_moment=spinner.getSelectedItem().toString();
		System.out.println("Selected Item value is...."+freq_moment);
		TextView text2=new TextView(this);
		text2.setText("Provide below info to get a message when your mobile in Danger!!!");
		l.addView(text2);
		
		TextView text3=new TextView(this);
		text3.setText("Email ID...");
		//tv.setTextSize(15f);
		text3.setLayoutParams(childViewParams);
		//text1.setTextColor(Color.RED);
		l.addView(text3);
		
		final EditText emailId=new EditText(this);
		emailId.setLayoutParams(childViewParams);
		l.addView(emailId);
		
		
		
		
		TextView text4=new TextView(this);
		text4.setText("Primary Contact 1");
		//tv.setTextSize(15f);
		text4.setLayoutParams(childViewParams);
		//text1.setTextColor(Color.RED);
		l.addView(text4);
		
		final EditText phno_1=new EditText(this);
		phno_1.setLayoutParams(childViewParams);
		l.addView(phno_1);
		phno_1.setInputType(InputType.TYPE_CLASS_NUMBER);
		
		TextView text5=new TextView(this);
		text5.setText("Primary Contact 1");
		//tv.setTextSize(15f);
		text5.setLayoutParams(childViewParams);
		//text1.setTextColor(Color.RED);
		l.addView(text5);
		
		final EditText phno_2=new EditText(this);
		phno_2.setLayoutParams(childViewParams);
		l.addView(phno_2);
		phno_2.setInputType(InputType.TYPE_CLASS_NUMBER);
		
		
		TextView text6=new TextView(this);
		text6.setText("Primary Contact 2");
		//tv.setTextSize(15f);
		text6.setLayoutParams(childViewParams);
		//text1.setTextColor(Color.RED);
		l.addView(text6);
		
		final EditText phno_3=new EditText(this);
		phno_3.setLayoutParams(childViewParams);
		l.addView(phno_3);
		phno_3.setInputType(InputType.TYPE_CLASS_NUMBER);
		
		Button b=new Button(this);
		b.setText("SAVE");
		b.setOnClickListener(new OnClickListener() {
			
			@SuppressWarnings("deprecation")
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String freq_moment=spinner.getSelectedItem().toString();
				String emailinfo=emailId.getText().toString();
				String phno1=phno_1.getText().toString();
				String phno2=phno_2.getText().toString();
				String phno3=phno_3.getText().toString();
				
				
				if(emailinfo.equalsIgnoreCase("")||phno1.equalsIgnoreCase("")||phno2.equalsIgnoreCase("")||phno3.equalsIgnoreCase(""))
				{
					
					AlertDialog alertDialog1 = new AlertDialog.Builder(
		                    MainActivity.this).create();
		 
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
		                    Toast.makeText(getApplicationContext(),
		                            "You clicked on OK", Toast.LENGTH_SHORT).show();
		                } 
		            });
		 
		            // Showing Alert Message
		            alertDialog1.show();
				}
		
				else
				{
				
				//Toast.makeText(this, "Peer contacts hasbenn added!!", Toast.LENGTH_SHORT).show();					
					mmm.insertintotable(freq_moment,emailId.getText().toString(), phno_1.getText().toString(), phno_2.getText().toString(), phno_3.getText().toString());
				
				System.out.println("Data inserted...navigating to next screen");
				
				navigate();
			}
			}
			
		});
		
		
		l.addView(b);
		sv.addView(l);
		sv.setVerticalScrollBarEnabled(true);
		sv.setHorizontalScrollBarEnabled(true);
		setContentView(sv);
		
		
	}

	private void navigate() {
		// TODO Auto-generated method stub
		
		LinearLayout l=new LinearLayout(this);
		
		LayoutParams lp=new LayoutParams(LinearLayout.LayoutParams.FILL_PARENT,LinearLayout.LayoutParams.FILL_PARENT);
		l.setLayoutParams(lp);
		l.setOrientation(LinearLayout.VERTICAL);
		
		LayoutParams childViewParams=new LayoutParams(LinearLayout.LayoutParams.FILL_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT);
		
		
		TextView headerTExt=new TextView(this);
		headerTExt.setText("Mobile Tracker");
		headerTExt.setTextSize(40f);
		headerTExt.setLayoutParams(childViewParams);
		headerTExt.setTextColor(Color.RED);
		l.addView(headerTExt);
		
		
		TextView text1=new TextView(this);
		text1.setText("Which Mode do you want to activate?");
		text1.setTextSize(20f);
		text1.setLayoutParams(childViewParams);
		//text1.setTextColor(Color.RED);
		l.addView(text1);
		
		
		Button b1=new Button(this);
		b1.setText("Activate Sensors");
		b1.setLayoutParams(childViewParams);	
		b1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				System.out.println("Activating Sensor....");
				Toast.makeText(getApplicationContext(), "Sensor code should go from here!!", Toast.LENGTH_SHORT);
			//	SensorCode s=new SensorCode(this,senSensorManager);
				Intent myIntent = new Intent(MainActivity.this, SensorEventsManager.class);
				//myIntent.putExtra("key", value); //Optional parameters
				MainActivity.this.startActivity(myIntent);
			}
		});
		
		Button b2=new Button(this);
		b2.setText("Activate Bluetooth");
		b2.setLayoutParams(childViewParams);	
		b2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				System.out.println("Activating Bluetooth....");
				Toast.makeText(getApplicationContext(), "BLuetooth code should go here!!", Toast.LENGTH_SHORT);
				BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
				if (mBluetoothAdapter == null) {
				    // Device does not support Bluetooth
					Toast.makeText(getApplicationContext(), "BLuetooth not available on this device", Toast.LENGTH_SHORT);
				}
				else
				if (!mBluetoothAdapter.isEnabled()) {
				    Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
				    startActivityForResult(enableBtIntent, 1);
				}
				else
				{
					 BluetoothAdapter BA;
					BA = BluetoothAdapter.getDefaultAdapter();
				Set<BluetoothDevice>pairedDevices;
				pairedDevices = BA.getBondedDevices();
				
				
				// If there are paired devices
				if (pairedDevices.size() > 0) {
				    // Loop through paired devices
				    for (BluetoothDevice device : pairedDevices) {
				    	Map<String, String> noof_paired_devices = new HashMap<String, String>();
						// Add the name and address to an array adapter to show in a ListView
				    	noof_paired_devices.put(device.getName(), device.getAddress());
				    	
				    }
				}
			}
			}
		});
		
		l.addView(b1);
		l.addView(b2);
		setContentView(l);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	public static void createDb(Context context)
	{
		MyDB db = new MyDB(context);

	}
	
	   
	
	
	    public void startSensor()
	    {
	    	//senSensorManager.registerListener((SensorEventListener) this.getApplicationContext(), senAccelerometer , SensorManager.SENSOR_DELAY_NORMAL);
	    }
	
}
*/