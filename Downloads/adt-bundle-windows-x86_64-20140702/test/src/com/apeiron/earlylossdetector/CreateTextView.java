package com.apeiron.earlylossdetector;

import android.content.Context;
import android.view.TextureView;
import android.widget.TextView;

public class CreateTextView {

	public static Context context;
	public CreateTextView(Context context)
	{
		this.context=context;
		
	}
	
	public static TextView createTextView(String name)
	{
		
		TextView tv=new TextView(context);
		
		
		return tv;
	}
	
}
