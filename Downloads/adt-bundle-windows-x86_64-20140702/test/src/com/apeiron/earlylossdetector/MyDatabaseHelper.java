package com.apeiron.earlylossdetector;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "earlylossdetector";

    private static final int DATABASE_VERSION =1;

    // Database creation sql statement
    private static final String my_device_info = "create table if not exists my_device_info("
    		+ "phno integer primary key , email_id text, bluetoothinfo text);";
    
    
    private static final String direct_community_contacts = "create table if not exists direct_community_contacts("
    		+ "id integer,phno integer primary key, email_id text, bluetoothinfo text);";
    
    
    private static final String in_direct_community_contacts = "create table if not exists in_direct_community_contacts("
    		+ "id integer  ,phno integer primary key, email_id text, bluetoothinfo text);";
    
    private static final String emergency_contacts = "create table if not exists emergency_contacts("
    		+ "id integer  ,phno integer primary key);";
    
    
    private static final String safe_locations = "create table if not exists safe_locations("
    		+ "id integer ,latitude text,longtitude text);";
    

    private static final String sensor_settings = "create table if not exists sensor_settings("
    		+ "id integer ,property text,value text);";
    
    
    
    
    
    public MyDatabaseHelper(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Method is called during creation of the database
    @Override
    public void onCreate(SQLiteDatabase database) {
    	
    	        database.execSQL(my_device_info);
    	        
    	        database.execSQL(direct_community_contacts);
    	        
    	        database.execSQL(in_direct_community_contacts);
    	        
    	        database.execSQL(emergency_contacts);
    	        
    	        database.execSQL(safe_locations);
    	        
      	        database.execSQL(sensor_settings);
    	        
    	        System.out.println("XXXXXXXXXXXXXXXXXXXXX tables are created..................");
       
     
        }

    // Method is called during an upgrade of the database,
    @Override
    public void onUpgrade(SQLiteDatabase database, int oldVersion,
            int newVersion) {
       
        //database.execSQL("DROP TABLE IF EXISTS MyEmployees");
        onCreate(database);
    }
}