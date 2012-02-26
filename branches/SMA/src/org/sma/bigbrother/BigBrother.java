package org.sma.bigbrother;

import java.util.List;

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

	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        
        //PE DEVICE REAL
        //SensorManager mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        //List<Sensor> deviceSensors = mSensorManager.getSensorList(Sensor.TYPE_ALL);
        
        //PE DEVICE VIRTUAL
        SensorManagerSimulator mSensorManager = SensorManagerSimulator.getSystemService(this, SENSOR_SERVICE);
        mSensorManager.connectSimulator();
        List<Integer> deviceSensors = mSensorManager.getSensors();
        
        Log.d(TAG, deviceSensors.toString());
        
        BroadcastReceiver batteryReceiver = new BroadcastReceiver() {
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
		IntentFilter filter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
		registerReceiver(batteryReceiver, filter);
    }
}