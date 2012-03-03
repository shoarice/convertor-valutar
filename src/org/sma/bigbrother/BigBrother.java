package org.sma.bigbrother;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;

public class BigBrother extends Activity {
    private static final String TAG = "BigBrother";
    private List<Sensor> sensors = new ArrayList<Sensor>();
    
	
    //private SensorManagerSimulator mSensorManager;
    private SensorManager mSensorManager;
    
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        
        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        List<Sensor> deviceSensors = mSensorManager.getSensorList(Sensor.TYPE_ALL);
        
        //CU SensorSimulator
       /* mSensorManager = SensorManagerSimulator.getSystemService(this, SENSOR_SERVICE);
        mSensorManager.connectSimulator();
        List<Integer> deviceSensors = mSensorManager.getSensors();*/
        
        Log.d(TAG, deviceSensors.toString());
        for (Sensor s : deviceSensors) {
        	sensors.add(s);
		}
        
        
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