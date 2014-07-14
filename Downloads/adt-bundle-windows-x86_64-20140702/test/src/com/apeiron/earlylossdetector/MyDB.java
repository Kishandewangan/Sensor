package com.apeiron.earlylossdetector;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.location.Location;
import android.location.LocationManager;

public class MyDB{  

	private static MyDatabaseHelper dbHelper;  
	static Context context;

	private static SQLiteDatabase database;  

	public final static String mobiletracker="mobiletracker"; 


	public final static String device_state="device_state"; 
	public final static String email_id="email_id"; 


	public final static String phno1="phno1"; 
	public final static String phno2="phno2"; 

	public final static String phno3="phno3"; 


	//MyDevice Info table infomation....

	public final static String my_device_info_table="my_device_info";
	public final static String my_device_info_email_id="email_id";
	public final static String my_device_info_phno="phno";
	public final static String my_device_info_bluetoothinfo="bluetoothinfo";
	
	//direct_community_contacts table Information
	public final static String direct_community_contacts_table="direct_community_contacts";
	public final static String direct_community_contacts_phno="phno";
	public final static String direct_community_contacts_email_id="email_id";
	public final static String direct_community_contacts_bluetoothinfo="bluetoothinfo";
	
	
	//Direct Community Contacts Table.
	
	public final static String in_direct_community_contacts_table="in_direct_community_contacts";
	public final static String in_direct_community_contacts_phno="phno";
	public final static String in_direct_community_contacts_email_id="email_id";
	public final static String in_direct_community_contacts_bluetoothinfo="bluetoothinfo";
	
	//Emergency Contacts Table
	public final static String emergency_contacts_table="emergency_contacts";
	public final static String emergency_contacts_phno="phno";
	
	
	// Safe locations table info
	public final static String safe_locations_table="safe_locations";
	public final static String safe_locations_latitude="latitude";
	public final static String safe_locations_longtitude="longtitude";
	
	//Sensor Settings table info
	public final static String sensor_settings_table="sensor_settings";
	public final static String sensor_settings_property="property";
	public final static String sensor_settings_value="value";
	
	/** 
	 * 
	 * @param context 
	 */  
	public MyDB(Context context){  
		dbHelper = new MyDatabaseHelper(context);  
		this.context=context;


		if(database==null)
		{
			database = dbHelper.getWritableDatabase();

		}
		else
			database=getDB();


	}

	public static SQLiteDatabase getDB()

	{
		return database;

	}
	

//Inserting into MyDevice ino table
	public static long insertinto_my_device_info(String email_id,String phno11,String binfo)
	{  
		ContentValues values = new ContentValues();  
		values.put(my_device_info_email_id, email_id);  

		values.put(my_device_info_phno,phno11);

		values.put(my_device_info_bluetoothinfo,binfo);
		//	new MainActivity().lockDevice();

		return database.insert(my_device_info_table, null, values);  
	}    

	// Inserting into direct_community_contacts table Information
		public static long insertinto_direct_community_contacts(String email_id,int phno11,String binfo)
		{  
			ContentValues values = new ContentValues();  
			values.put(direct_community_contacts_email_id, email_id);  

			values.put(direct_community_contacts_phno,phno11);

			values.put(direct_community_contacts_bluetoothinfo,binfo);
			//	new MainActivity().lockDevice();

			return database.insert(direct_community_contacts_table, null, values);  
		}    

	
//Inserting into in_direct_community_contacts
	    public static long insertinto_in_direct_community_contacts(String email_id,String phno11,String binfo)
		{  
			ContentValues values = new ContentValues();  
			values.put(in_direct_community_contacts_email_id, email_id);  

			values.put(in_direct_community_contacts_phno,phno11);

			values.put(in_direct_community_contacts_bluetoothinfo,binfo);
			//	new MainActivity().lockDevice();

			return database.insert(in_direct_community_contacts_table, null, values);  
		}    

		//Emergency Contacts Table
		 public static long insertinto_emergency_contacts(int phno1)
			{  
				ContentValues values = new ContentValues();  
				values.put(emergency_contacts_phno, phno1);  

				
			return database.insert(emergency_contacts_table, null, values);  
			}    
	    
	    

			// Safe locations table info
	
			 public static long insertinto_safe_locations(String lat,String longtitud)
				{  
					ContentValues values = new ContentValues();  
					values.put(safe_locations_latitude, lat);  
					values.put(safe_locations_longtitude, longtitud);
					return database.insert(safe_locations_table, null, values);  
				}    
		 
		 
			 //Sensor settings insertion.
				
				 public static long insertinto_sensor_settings(String prop,String val)
					{  
						ContentValues values = new ContentValues();  
						values.put(sensor_settings_property, prop);  

						values.put(sensor_settings_value, val);

						return database.insert(sensor_settings_table, null, values);  
					}    
				 

	public static Cursor getDeviceState()
	{
		Cursor mCursor= database.rawQuery("select device_ from mobiletracker", null);
		if ( mCursor != null && mCursor.getCount() > 0 )
		{	
			mCursor.moveToFirst();  


		}  
		return mCursor; // iterate to get each value.
	}
	
	///Get peer info and Emergency Contact number so that we can say device is enrolled or not...If it is registered 
	// then it should return the true ... if it is true then enable the start and stop button on the home screen


	public boolean isenrolled()
	{
		Cursor mCursor1= database.rawQuery("select count(*) from emergency_contacts", null);
		//Cursor mCursor2= database.rawQuery("select count(*) from emergency_contacts", null);
		System.out.println("mCusro1 value..."+mCursor1);
		//System.out.println("mCusro1 value..."+mCursor2);
		System.out.println("XXXXXXXXXXXX count...."+mCursor1.getCount());
		//System.out.println("XXXXXXXXXXXX count...."+mCursor2.getCount());
		System.out.println("check mcursor is null..."+(mCursor1==null));
		if(mCursor1.moveToFirst())
		{
			System.out.println("Cursor is null.... so returning false");
			return false;
		}
		else
		{
		return true;
		}
	}

	public static String getLocationData()

	{


		String locationDetails="Location Info";
		LocationManager lm;
		//Context c=this.getApplicationContext();

		lm= (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
		if(lm==null)
		{
			System.out.println("location Manager is null");
		}
		Location loc=lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
		System.out.println("Location Object..."+loc);
		if (loc != null) 
		{
			double latitude = loc.getLatitude();
			double  longitude = loc.getLongitude();
			locationDetails=locationDetails+"latitude: "+latitude+"    longitude: "+longitude;
			System.out.println("Location Details" +locationDetails);
		}
		else 
		{
			System.out.println("Location Not available");
		}
		return locationDetails;
	}

}

