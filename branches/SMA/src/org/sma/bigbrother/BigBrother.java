package org.sma.bigbrother;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class BigBrother extends Activity {
    	
    private OnClickListener batteryListener = new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			Intent batteryIntent = new Intent(BigBrother.this, Battery.class);
			startActivity(batteryIntent);
		}
	};
	
	private OnClickListener networkListener = new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			Intent networkIntent = new Intent(BigBrother.this, Network.class);
			startActivity(networkIntent);
		}
	};
	
	private OnClickListener sensorsListener = new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			Intent sensorsIntent = new Intent(BigBrother.this, Sensors.class);
			startActivity(sensorsIntent);
		}
	};
	
	private OnClickListener processesListener = new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			Intent processesIntent = new Intent(BigBrother.this, Processes.class);
			startActivity(processesIntent);
		}
	};
	
	private OnClickListener telephonyListener = new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			Intent telephonyIntent = new Intent(BigBrother.this, Telephony.class);
			startActivity(telephonyIntent);
		}
	};
	
	private OnClickListener locationListener = new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			Intent locationIntent = new Intent(BigBrother.this, Location.class);
			startActivity(locationIntent);
		}
	};
	
	private OnClickListener logListener = new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			Intent logIntent = new Intent(BigBrother.this, Log.class);
			startActivity(logIntent);
		}
	};
	
	private OnClickListener aboutListener = new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			Intent aboutIntent = new Intent(BigBrother.this, About.class);
			startActivity(aboutIntent);
		}
	};
	
    
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
                      
        Button Battery = (Button) findViewById(R.id.Battery);
        Button Network = (Button) findViewById(R.id.Network);
        Button Sensors = (Button) findViewById(R.id.Sensors);
        Button Processes = (Button) findViewById(R.id.Processes);
        Button Telephony = (Button) findViewById(R.id.Telephony);
        Button Location = (Button) findViewById(R.id.Location);
        Button Log = (Button) findViewById(R.id.Log);
        Button About = (Button) findViewById(R.id.About); 
       
        Battery.setOnClickListener(batteryListener);
        Network.setOnClickListener(networkListener);
        Sensors.setOnClickListener(sensorsListener);
        Processes.setOnClickListener(processesListener);
        Telephony.setOnClickListener(telephonyListener);
        Location.setOnClickListener(locationListener);
        Log.setOnClickListener(logListener);
        About.setOnClickListener(aboutListener);

    }
}