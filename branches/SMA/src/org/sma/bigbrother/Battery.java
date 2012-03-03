package org.sma.bigbrother;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class Battery extends Activity {

	BroadcastReceiver batteryReceiver;
	IntentFilter filter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.battery);
		
		batteryReceiver = new BroadcastReceiver() {
            private int lvl = 0;
            private int scl = 0;
            private int temp = 0;
            private int volt = 0;
            private int status = 0;
            private int health = 0;
            ProgressBar bar = (ProgressBar) findViewById(R.id.progressBarBattery);
            TextView textLevel = (TextView) findViewById(R.id.textViewBatteryLevelPercentage);
            TextView textHealth = (TextView) findViewById(R.id.textViewBatteryHealth);
            TextView textStatus = (TextView) findViewById(R.id.textViewBatteryStatus);
            TextView textTemp = (TextView) findViewById(R.id.textViewBatteryTemperature);
            TextView textVolt = (TextView) findViewById(R.id.textViewBatteryVoltage);
            ImageView img = (ImageView) findViewById(R.id.imageViewBattery);
            
			@Override
			public void onReceive(Context context, Intent intent) {
				lvl = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, 0);
				scl = intent.getIntExtra(BatteryManager.EXTRA_SCALE, 0);
				health = intent.getIntExtra(BatteryManager.EXTRA_HEALTH, BatteryManager.BATTERY_HEALTH_UNKNOWN);
				status = intent.getIntExtra(BatteryManager.EXTRA_STATUS, BatteryManager.BATTERY_STATUS_UNKNOWN);
				temp = intent.getIntExtra(BatteryManager.EXTRA_TEMPERATURE, 0);
				volt = intent.getIntExtra(BatteryManager.EXTRA_VOLTAGE, 0);
				
				bar.setMax(scl);
				bar.setProgress(lvl);
				textLevel.setText(String.valueOf(lvl));
				textTemp.setText(String.valueOf(temp) + " C");
				textVolt.setText(String.valueOf(volt) + " V");
				
				switch (status) {
				case BatteryManager.BATTERY_STATUS_CHARGING:
					textStatus.setText("CHARGING");
					break;
				case BatteryManager.BATTERY_STATUS_DISCHARGING:
					textStatus.setText("DISCHARGING");
					break;
				case BatteryManager.BATTERY_STATUS_FULL:
					textStatus.setText("FULL");
					break;
				case BatteryManager.BATTERY_STATUS_NOT_CHARGING:
					textStatus.setText("CHARGING");
					break;
				default:
					textStatus.setText("UNKNOWN");
					break;
				}
				
				switch (health) {
				case BatteryManager.BATTERY_HEALTH_DEAD:
					textHealth.setText("DEAD");
					break;
				case BatteryManager.BATTERY_HEALTH_GOOD:
					textHealth.setText("GOOD");
					break;
				case BatteryManager.BATTERY_HEALTH_OVER_VOLTAGE:
					textHealth.setText("OVER VOLTAGE");
					break;
				case BatteryManager.BATTERY_HEALTH_OVERHEAT:
					textHealth.setText("OVERHEAT");
					break;
				case BatteryManager.BATTERY_HEALTH_UNSPECIFIED_FAILURE:
					textHealth.setText("UNSPECIFIED FAILURE");
					break;
				default:
					textHealth.setText("UNKNOWN");
					break;
				}
				if(lvl > 75)
					img.setImageResource(R.drawable.batt_full);
				else if(lvl > 50)
					img.setImageResource(R.drawable.batt_afull);
				else if(lvl > 25)
					img.setImageResource(R.drawable.batt_aempty);
				else if(lvl <= 25)
					img.setImageResource(R.drawable.batt_empty);
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
		//unregisterReceiver(batteryReceiver);
	}
	

}
