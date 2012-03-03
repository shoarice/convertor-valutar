package org.sma.bigbrother;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Sensors extends Activity implements SensorEventListener{
	private SensorManager mSensorManager;
	private List<Sensor> sensors = new ArrayList<Sensor>();
	private List<Sensor> deviceSensors;
	LinearLayout layout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sensors);
		
		layout = (LinearLayout) findViewById(R.id.sensors_layout);
		layout.setPadding(10, 10, 10, 10);
		mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        deviceSensors = mSensorManager.getSensorList(Sensor.TYPE_ALL);

        //CU SensorSimulator
        //mSensorManager = SensorManager.getSystemService(this, SENSOR_SERVICE);
        //mSensorManager.connectSimulator();
        //List<Integer> deviceSensors = mSensorManager.getSensors();
        
		for (Sensor s : deviceSensors) {
        	//mSensorManager.registerListener(this, s, SensorManager.SENSOR_DELAY_NORMAL);
        	
        	String type = null;
        	switch (s.getType()) {
			case Sensor.TYPE_ACCELEROMETER:
				type = "ACCELEROMETER";
				break;
			case Sensor.TYPE_GRAVITY:
				type = "GRAVITY";
				break;
			case Sensor.TYPE_GYROSCOPE:
				type = "GYROSCOPE";
				break;
			case Sensor.TYPE_LIGHT:
				type = "LIGHT";
				break;
			case Sensor.TYPE_LINEAR_ACCELERATION:
				type = "ACCELERATION";
				break;
			case Sensor.TYPE_MAGNETIC_FIELD:
				type = "MAGNETIC FIELD";
				break;
			case Sensor.TYPE_ORIENTATION:
				type = "ORIENTATION";
				break;
			case Sensor.TYPE_PRESSURE:
				type = "PRESSURE";
				break;
			case Sensor.TYPE_PROXIMITY:
				type = "PROXIMITY";
				break;
			case Sensor.TYPE_ROTATION_VECTOR:
				type = "VECTOR";
				break;
			case Sensor.TYPE_TEMPERATURE:
				type = "TEMPERATURE";
				break;
			default:
				type = "UNKOWN";
				break;
			}
        	addSensorInfo(type, s.getName(), String.valueOf(s.getPower()), 
        			String.valueOf(s.getMaximumRange()), String.valueOf(s.getResolution()), 
        			s.getVendor(), String.valueOf(s.getVersion()));
		}
	}

	public void addSensorInfo(String type, String name, String power, 
			String maxRange, String resolution, String vendor, String version) {
		addSensorInfo(type, name, power, maxRange, resolution, vendor, version, null);
	}
	public void addSensorInfo(String type, String name, String power, 
			String maxRange, String resolution, String vendor, String version, String unit) {
		
		addRow("Type:", type);
		addRow("Name:", name);
		addRow("Power:", power, "mA");
		addRow("Max Range:", maxRange, unit);
		addRow("Resolution:", resolution, unit);
		addRow("Vendor:", vendor);
		addRow("Version:", version);
		addRow(" ", " ");
	}

	public void addRow(String label, String value) {
		addRow(label, value, null);
	}
	public void addRow(String label, String value, String unit) {
		LinearLayout linearLayout = new LinearLayout(getApplicationContext());
		linearLayout.setOrientation(LinearLayout.HORIZONTAL);
		
		TextView textLabelName = new TextView(getApplicationContext());
		textLabelName.setText(label+" ");
		textLabelName.setTextAppearance(getApplicationContext(), android.R.style.TextAppearance_Medium);
		
		TextView textName = new TextView(getApplicationContext());
		if(unit != null)
			textName.setText(value + " " +unit);
		else
			textName.setText(value);
		
		linearLayout.addView(textLabelName);
		linearLayout.addView(textName);
		
		layout.addView(linearLayout);
	}
	
	@Override
	public void onAccuracyChanged(Sensor s, int arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onSensorChanged(SensorEvent se) {
		// TODO Auto-generated method stub
	}
	
	@Override
	protected void onPause() {
		super.onPause();
		/*for (Sensor s : deviceSensors) {
        	mSensorManager.unregisterListener(this, s);
		}*/
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();

		for (Sensor s : deviceSensors) {
        	mSensorManager.registerListener(this, s, SensorManager.SENSOR_DELAY_NORMAL);
		}
	}

	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		/*for (Sensor s : deviceSensors) {
        	mSensorManager.unregisterListener(this, s);
		}*/
	}




	
	
}
