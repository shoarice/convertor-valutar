package org.sma.bigbrother;

import java.util.ArrayList;
import java.util.List;

import org.openintents.sensorsimulator.hardware.Sensor;
import org.openintents.sensorsimulator.hardware.SensorManagerSimulator;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.ProgressBar;

public class BigBrother extends Activity {
    private static final String TAG = "BigBrother";
    private List<Sensor> sensors = new ArrayList<Sensor>();
    BroadcastReceiver batteryReceiver;
	IntentFilter filter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
    private SensorManagerSimulator mSensorManager;
    //private SensorManager mSensorManager;
    
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        
        //PE DEVICE REAL
        //mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        //List<Sensor> deviceSensors = mSensorManager.getSensorList(Sensor.TYPE_ALL);
        
        //PE DEVICE VIRTUAL
        mSensorManager = SensorManagerSimulator.getSystemService(this, SENSOR_SERVICE);
        mSensorManager.connectSimulator();
        List<Integer> deviceSensors = mSensorManager.getSensors();
        
        Log.d(TAG, deviceSensors.toString());
        for (Integer sensorType : deviceSensors) {
        	Sensor s = mSensorManager.getDefaultSensor(sensorType);
        	sensors.add(s);
		}
        
        
        doBattery();
    }

	private void doBattery() {
		batteryReceiver = new BroadcastReceiver() {
            private int lvl = 0;
            private int scl = 0;
            ProgressBar bar = (ProgressBar) findViewById(R.id.progressBar);

			@Override
			public void onReceive(Context context, Intent intent) {
				lvl = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, 0);
				scl = intent.getIntExtra(BatteryManager.EXTRA_SCALE, 0);
				
				bar.setMax(scl);
				bar.setProgress(lvl);
			}
		};
		registerReceiver(batteryReceiver, filter);
	}

	@Override
	protected void onPause() {
		super.onPause();
		unregisterReceiver(batteryReceiver);
		//for each listener
		//mSensorManager.unregisterListener(listener);
	}

	@Override
	protected void onResume() {
		super.onResume();
		registerReceiver(batteryReceiver, filter);
		//for each sensor
		//mSensorManager.registerListener(listener, sensor, SensorManager.SENSOR_DELAY_NORMAL);
	}
	
	
}