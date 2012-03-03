package org.sma.bigbrother;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Bundle;
import android.widget.ProgressBar;

public class Battery extends Activity {

	BroadcastReceiver batteryReceiver;
	IntentFilter filter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		batteryReceiver = new BroadcastReceiver() {
            private int lvl = 0;
            private int scl = 0;
            ProgressBar bar = (ProgressBar) findViewById(R.id.progressBar);

			@Override
			public void onReceive(Context context, Intent intent) {
				lvl = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, 0);
				scl = intent.getIntExtra(BatteryManager.EXTRA_SCALE, 0);
				intent.getIntExtra(BatteryManager.EXTRA_HEALTH, 0);
				intent.getIntExtra(BatteryManager.EXTRA_STATUS, BatteryManager.BATTERY_STATUS_UNKNOWN);
				intent.getIntExtra(BatteryManager.EXTRA_HEALTH, BatteryManager.BATTERY_HEALTH_UNKNOWN);
				intent.getIntExtra(BatteryManager.EXTRA_TEMPERATURE, 0);
				intent.getIntExtra(BatteryManager.EXTRA_VOLTAGE, 0);
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
	}

	@Override
	protected void onResume() {
		super.onResume();
		registerReceiver(batteryReceiver, filter);
	}

	@Override
	protected void onStop() {
		super.onStop();
	}
	

}
