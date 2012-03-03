package org.sma.bigbrother;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.hardware.Sensor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class BigBrother extends Activity {
    private static final String TAG = "BigBrother";
    private List<Sensor> sensors = new ArrayList<Sensor>();
    	
    private OnClickListener batteryListener = new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			Intent batteryIntent = new Intent(BigBrother.this, Battery.class);
			startActivity(batteryIntent);
		}
	};
    
    //private SensorManagerSimulator mSensorManager;
    //private SensorManager mSensorManager;
    
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
        
       
	
	
       /* mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        List<Sensor> deviceSensors = mSensorManager.getSensorList(Sensor.TYPE_ALL);
        
        //CU SensorSimulator
        mSensorManager = SensorManagerSimulator.getSystemService(this, SENSOR_SERVICE);
        mSensorManager.connectSimulator();
        List<Integer> deviceSensors = mSensorManager.getSensors();
        
        Log.d(TAG, deviceSensors.toString());
        for (Sensor s : deviceSensors) {
        	sensors.add(s);
		}*/
        
        
    }

	@Override
	protected void onPause() {
		super.onPause();
		
		//for each listener
		//mSensorManager.unregisterListener(listener);
	}

	@Override
	protected void onResume() {
		super.onResume();
		
		//for each sensor
		//mSensorManager.registerListener(listener, sensor, SensorManager.SENSOR_DELAY_NORMAL);
	}
	
	
}