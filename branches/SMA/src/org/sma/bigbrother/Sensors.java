package org.sma.bigbrother;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Sensors extends Activity{
	

	private SensorManager mSensorManager;
	private List<Sensor> deviceSensors;
	private Map<Integer, SensorEventListener> listeners = new HashMap<Integer, SensorEventListener>();
	LinearLayout layout;
	
	private ArrayList<TextView> t = new ArrayList<TextView>();
	
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
        
        String type = null;
        String unit = null;
        SensorEventListener listener = null;
        List<String> fields = new ArrayList<String>();
		for (Sensor s : deviceSensors) {
			fields.clear();
        	
			switch (s.getType()) {
			case Sensor.TYPE_ACCELEROMETER:
				type = "ACCELEROMETER";
				unit = "m/s^2";
				listener = new Listenerr();
				fields.add("Acceleration minus Gx:");
				fields.add("Acceleration minus Gy:");
				fields.add("Acceleration minus Gz:");
				listeners.put(Sensor.TYPE_ACCELEROMETER, listener);
				break;
			case Sensor.TYPE_GRAVITY:
				type = "GRAVITY";
				unit = "m/s^2";
				fields.add("Gravity X:");
				fields.add("Gravity Y:");
				fields.add("Gravity Z:");
				listener = new Listenerr();
				listeners.put(Sensor.TYPE_GRAVITY, listener);
				break;
			case Sensor.TYPE_GYROSCOPE:
				type = "GYROSCOPE";
				unit = "rad/s";
				fields.add("Angular speed X:");
				fields.add("Angular speed Y:");
				fields.add("Angular speed Z:");
				listeners.put(Sensor.TYPE_GYROSCOPE, listener);
				break;
			case Sensor.TYPE_LIGHT:
				type = "LIGHT";
				unit = "lux";
				fields.add("Light:");
				listener = new Listenerr();
				listeners.put(Sensor.TYPE_LIGHT, listener);
				break;
			case Sensor.TYPE_LINEAR_ACCELERATION:
				type = "ACCELERATION";
				unit = "m/s^2";
				fields.add("Acceleration X:");
				fields.add("Acceleration Y:");
				fields.add("Acceleration Z:");
				listener = new Listenerr();
				listeners.put(Sensor.TYPE_LINEAR_ACCELERATION, listener);
				break;
			case Sensor.TYPE_MAGNETIC_FIELD:
				type = "MAGNETIC FIELD";
				unit = "uT";
				listener = new Listenerr();
				fields.add("ambient magnetic field X:");
				fields.add("ambient magnetic field Y:");
				fields.add("ambient magnetic field Z:");
				listeners.put(Sensor.TYPE_MAGNETIC_FIELD, listener);
				break;
			case Sensor.TYPE_ORIENTATION:
				type = "ORIENTATION";
				unit = "degrees";
				fields.add("Azimuth:");
				fields.add("Pitch:");
				fields.add("Roll:");
				listener = new Listenerr();
				listeners.put(Sensor.TYPE_ORIENTATION, listener);
				break;
			case Sensor.TYPE_PRESSURE:
				type = "PRESSURE";
				unit = "hPa";
				fields.add("Pressure:");
				listener = new Listenerr();
				listeners.put(Sensor.TYPE_PRESSURE, listener);
				break;
			case Sensor.TYPE_PROXIMITY:
				type = "PROXIMITY";
				unit = "cm";
				fields.add("Distance:");
				listener = new Listenerr();
				listeners.put(Sensor.TYPE_PROXIMITY, listener);
				break;
			case Sensor.TYPE_ROTATION_VECTOR:
				type = "ROTATION";
				listener = new Listenerr();
				fields.add("Rotation X:");
				fields.add("Rotation Y:");
				fields.add("Rotation Z:");
				listeners.put(Sensor.TYPE_ROTATION_VECTOR, listener);
				break;
			case Sensor.TYPE_TEMPERATURE:
				type = "TEMPERATURE";
				unit = "degrees C";
				fields.add("Temperature:");
				listener = new Listenerr();
				listeners.put(Sensor.TYPE_TEMPERATURE, listener);
				break;
			default:
				type = "UNKOWN";
				break;
			}
        	
        	addSensorInfo(type, s.getName(), String.valueOf(s.getPower()), 
        			String.valueOf(s.getMaximumRange()), String.valueOf(s.getResolution()), 
        			s.getVendor(), String.valueOf(s.getVersion()), unit,fields);
        	
       		((Listenerr) listener).setTV(t);
       		
       		mSensorManager.registerListener(listener, s, SensorManager.SENSOR_DELAY_UI);
		}
	}

	public void addSensorInfo(String type, String name, String power, 
			String maxRange, String resolution, String vendor, String version, List<String> specialRows) {
		addSensorInfo(type, name, power, maxRange, resolution, vendor, version, null, specialRows);
	}
	public void addSensorInfo(String type, String name, String power, 
			String maxRange, String resolution, String vendor, String version, String unit, List<String> specialRows) {
		
		addRow("Type:", type);
		addRow("Name:", name);
		addRow("Power:", power, "mA");
		addRow("Max Range:", maxRange, unit);
		addRow("Resolution:", resolution, unit);
		addRow("Vendor:", vendor);
		addRow("Version:", version);
		t.clear();
		
		if(specialRows != null)
			for (String e : specialRows) {
				addRow(e, "");
			}
		addRow(" ", " ");
		t.remove(t.size() - 1);
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
		
		t.add(textName);
		layout.addView(linearLayout);
	}
	
	@Override
	protected void onPause() {
		super.onPause();
		for (SensorEventListener s : listeners.values()) {
        	mSensorManager.unregisterListener(s);
		}
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();

		for (Entry<Integer, SensorEventListener> entry : listeners.entrySet()) {
        	mSensorManager.registerListener(entry.getValue(), 
        			mSensorManager.getDefaultSensor(entry.getKey()), SensorManager.SENSOR_DELAY_UI);
		}
	}

	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		/*for (SensorEventListener s : listeners.values()) {
        	mSensorManager.unregisterListener(s);
		}*/
	}
	public class Listenerr implements SensorEventListener{
		private ArrayList<TextView> tv = new ArrayList<TextView>();
		
		public void setTV(ArrayList<TextView> tv){
			this.tv.addAll(tv);
		}

		@Override
		public void onAccuracyChanged(Sensor sensor, int accuracy) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onSensorChanged(SensorEvent event) {
			for (int i=0; i < tv.size(); i++) {
				if(i < event.values.length)
					tv.get(i).setText(String.valueOf(event.values[i]));
			}
		}
	}
	
	/*public class AccListener extends Listenerr implements SensorEventListener{

		@Override
		public void onAccuracyChanged(Sensor arg0, int arg1) {
			// TODO Auto-generated method stub
		}

		@Override
		public void onSensorChanged(SensorEvent arg0) {
			t.get(0).setText(String.valueOf(arg0.values[0]));
			//t.get(1).setText(String.valueOf(arg0.values[1]));
			//t.get(2).setText(String.valueOf(arg0.values[2]));
		}
		
	}
	
	public class TempListener extends Listenerr implements SensorEventListener {

		@Override
		public void onAccuracyChanged(Sensor arg0, int arg1) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onSensorChanged(SensorEvent arg0) {
			t.get(0).setText(String.valueOf(arg0.values[0]));
		}

	}

	public class RotListener extends Listenerr implements SensorEventListener {

		@Override
		public void onAccuracyChanged(Sensor arg0, int arg1) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onSensorChanged(SensorEvent arg0) {
			t.get(0).setText(String.valueOf(arg0.values[0]));
			//t.get(1).setText(String.valueOf(arg0.values[1]));
			//t.get(2).setText(String.valueOf(arg0.values[2]));
		}

	}

	public class ProxListener extends Listenerr implements SensorEventListener {

		@Override
		public void onAccuracyChanged(Sensor arg0, int arg1) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onSensorChanged(SensorEvent arg0) {
			t.get(0).setText(String.valueOf(arg0.values[0]));
		}

	}

	public class PressListener extends Listenerr implements SensorEventListener {

		@Override
		public void onAccuracyChanged(Sensor arg0, int arg1) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onSensorChanged(SensorEvent arg0) {
			t.get(0).setText(String.valueOf(arg0.values[0]));
		}

	}

	public class OrientListener extends Listenerr implements SensorEventListener {

		@Override
		public void onAccuracyChanged(Sensor arg0, int arg1) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onSensorChanged(SensorEvent arg0) {
			t.get(0).setText(String.valueOf(arg0.values[0]));
			//t.get(1).setText(String.valueOf(arg0.values[1]));
			//t.get(2).setText(String.valueOf(arg0.values[2]));
		}

	}

	public class MagListener extends Listenerr implements SensorEventListener {

		@Override
		public void onAccuracyChanged(Sensor arg0, int arg1) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onSensorChanged(SensorEvent arg0) {
			t.get(0).setText(String.valueOf(arg0.values[0]));
			//t.get(1).setText(String.valueOf(arg0.values[1]));
			//t.get(2).setText(String.valueOf(arg0.values[2]));
		}

	}

	public class LinAccListener extends Listenerr implements SensorEventListener {

		@Override
		public void onAccuracyChanged(Sensor arg0, int arg1) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onSensorChanged(SensorEvent arg0) {
			t.get(0).setText(String.valueOf(arg0.values[0]));
			//t.get(1).setText(String.valueOf(arg0.values[1]));
			//t.get(2).setText(String.valueOf(arg0.values[2]));

		}

	}

	public class LightListener extends Listenerr implements SensorEventListener {

		@Override
		public void onAccuracyChanged(Sensor arg0, int arg1) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onSensorChanged(SensorEvent arg0) {
			t.get(0).setText(String.valueOf(arg0.values[0]));
		}

	}

	public class GyroListener extends Listenerr  implements SensorEventListener {

		@Override
		public void onAccuracyChanged(Sensor arg0, int arg1) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onSensorChanged(SensorEvent arg0) {
			t.get(0).setText(String.valueOf(arg0.values[0]));
			//t.get(1).setText(String.valueOf(arg0.values[1]));
			//t.get(2).setText(String.valueOf(arg0.values[2]));

		}

	}

	public class GravListener extends Listenerr implements SensorEventListener {
 
		@Override
		public void onAccuracyChanged(Sensor arg0, int arg1) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onSensorChanged(SensorEvent arg0) {
			t.get(0).setText(String.valueOf(arg0.values[0]));
			//t.get(1).setText(String.valueOf(arg0.values[1]));
			//t.get(2).setText(String.valueOf(arg0.values[2]));

		}

	}
*/


	
	
}
