package com.apeiron.earlylossdetector;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.InputType;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ScrollView;
import android.widget.TextView;

public class  Community  {
	
		public static Context context;
		/*SensorManager senSensorManager;
		  Sensor senAccelerometer;*/
		
	public Community(Context context)
		{
			this.context=context;
		
			
			System.out.println("Reached Community reg screen");
		}
	
	public static ScrollView getCommunity()
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
			headerTExt.setText("Community Registration");
			headerTExt.setTextSize(20f);
			headerTExt.setLayoutParams(childViewParams);
			headerTExt.setTextColor(Color.RED);
			headerTExt.setGravity(Gravity.CENTER);
			regLayout.addView(headerTExt);
			
			
			TextView PeersInfo=new TextView(context);
			PeersInfo.setText("Peers Info");
			PeersInfo.setTextSize(18f);
			PeersInfo.setLayoutParams(childViewParams);
			//text1.setTextColor(Color.RED);
			regLayout.addView(PeersInfo);
			
		/*	
			LinearLayout bottom=new LinearLayout(context);
			bottom.setLayoutParams(childViewParams2);
			bottom.setOrientation(LinearLayout.HORIZONTAL);
			
			
			ImageButton ib=new ImageButton(context);
			ib.setImageResource(R.drawable.plus1);
			ib.setLayoutParams(childViewParams2);
			
			bottom.addView(ib);
			
			regLayout.addView(bottom);
			final LinearLayout addingpeers=new LinearLayout(context);
			addingpeers.setLayoutParams(childViewParams);
			addingpeers.setOrientation(LinearLayout.VERTICAL);
			addingpeers.setEnabled(true);

			regLayout.addView(addingpeers);
			ib.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					
					TextView peer=new TextView(context);
					
					//phno, email
					peer.setText("Peer Info");
					peer.setLayoutParams(childViewParams);
					addingpeers.addView(peer);
					
					TextView peerphno=new TextView(context);
					peerphno.setText("Peer 1");
					peerphno.setTextSize(18f);
					peerphno.setLayoutParams(childViewParams2);
					//text1.setTextColor(Color.RED);
					addingpeers.addView(peer);
					
					final EditText peer_contact_no=new EditText(context);
					peer_contact_no.setLayoutParams(childViewParams);
					regLayout.addView(peer_contact_no);
					peer_contact_no.setTextColor(Color.BLACK);
					peer_contact_no.setInputType(InputType.TYPE_CLASS_NUMBER);
					
					addingpeers.addView(peer);
					//addingpeers.setEnabled(true);
				}
			});
			*/
			
			TextView text1=new TextView(context);
			text1.setText("Peer 1");
			text1.setTextSize(18f);
			text1.setLayoutParams(childViewParams);
			//text1.setTextColor(Color.RED);
			regLayout.addView(text1);
			
			final EditText peer1_contact_no=new EditText(context);
			peer1_contact_no.setLayoutParams(childViewParams);
			regLayout.addView(peer1_contact_no);
			peer1_contact_no.setInputType(InputType.TYPE_CLASS_NUMBER);
			
			
			
			
			TextView text2=new TextView(context);
			text2.setText("Peer 2");
			text2.setTextSize(18f);
			text2.setLayoutParams(childViewParams);
			//text1.setTextColor(Color.RED);
			regLayout.addView(text2);
			
			final EditText peer2_contact_no=new EditText(context);
			peer2_contact_no.setLayoutParams(childViewParams);
			regLayout.addView(peer2_contact_no);
			peer2_contact_no.setInputType(InputType.TYPE_CLASS_NUMBER);
			
			
			
			
			TextView text3=new TextView(context);
			text3.setText("Peer 3");
			text3.setTextSize(18f);
			text3.setLayoutParams(childViewParams);
			//text1.setTextColor(Color.RED);
			regLayout.addView(text3);
						
			final EditText peer3_contact_no=new EditText(context);
			peer3_contact_no.setLayoutParams(childViewParams);
			regLayout.addView(peer3_contact_no);
			peer3_contact_no.setInputType(InputType.TYPE_CLASS_NUMBER);
			
			
			
			
			
			
			TextView text4=new TextView(context);
			text4.setText("Peer 4");
			text4.setTextSize(18f);
			text4.setLayoutParams(childViewParams);
			//text1.setTextColor(Color.RED);
			regLayout.addView(text4);
						
			final EditText peer4_contact_no=new EditText(context);
			peer4_contact_no.setLayoutParams(childViewParams);
			regLayout.addView(peer4_contact_no);
			peer4_contact_no.setInputType(InputType.TYPE_CLASS_NUMBER);
			
			
			
			
			
			

			TextView text5=new TextView(context);
			text5.setText("Peer 5");
			text5.setTextSize(18f);
			text5.setLayoutParams(childViewParams);
			//text1.setTextColor(Color.RED);
			regLayout.addView(text5);
						
			final EditText peer5_contact_no=new EditText(context);
			peer5_contact_no.setLayoutParams(childViewParams);
			regLayout.addView(peer5_contact_no);
			peer5_contact_no.setInputType(InputType.TYPE_CLASS_NUMBER);
			peer5_contact_no.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					
					System.out.println("PEER5...............Pressing");
				}
			});
			
			
			
			
			Button b=new Button(context);
			b.setText("Add");
			b.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					System.out.println("Saving Peers Info>....");
					
					MyDB mm=new MyDB(context);
									
					
					if(!peer1_contact_no.getText().toString().equalsIgnoreCase(""))
					{	
					int contactno1=Integer.parseInt(peer1_contact_no.getText().toString());
					mm.insertinto_direct_community_contacts("", contactno1, "");
					
					}
					
					if(!peer2_contact_no.getText().toString().equalsIgnoreCase(""))
					{	
					int contactno1=Integer.parseInt(peer1_contact_no.getText().toString());
					mm.insertinto_direct_community_contacts("", contactno1, "");
					
					}
					if(!peer3_contact_no.getText().toString().equalsIgnoreCase(""))
					{	
					int contactno1=Integer.parseInt(peer1_contact_no.getText().toString());
					mm.insertinto_direct_community_contacts("", contactno1, "");
					
					}
					if(!peer4_contact_no.getText().toString().equalsIgnoreCase(""))
					{	
					int contactno1=Integer.parseInt(peer1_contact_no.getText().toString());
					mm.insertinto_direct_community_contacts("", contactno1, "");
					
					}
					if(!peer5_contact_no.getText().toString().equalsIgnoreCase(""))
					{	
					int contactno1=Integer.parseInt(peer1_contact_no.getText().toString());
					mm.insertinto_direct_community_contacts("", contactno1, "");
					
					}
					
					
					
					
				Intent i=new Intent(context, NewHome.class);
				i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				context.startActivity(i);
				}
			});
						
			regLayout.addView(b);
			sv.setBackgroundColor(Color.CYAN);
			sv.addView(regLayout);
			
			
			return sv;
			
		
		
	}
}

		
			
		
	

