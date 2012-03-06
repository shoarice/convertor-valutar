package org.sma.bigbrother;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Location extends Activity {
	private LocationManager ls;
	private LinearLayout layout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.location);
		
		//doStuff();
		
	}

	private void doStuff() {
		ls = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
		List<String> providers = ls.getProviders(true);
		
		layout = (LinearLayout) findViewById(R.id.location_layout);
		
		for (String string : providers) {
			//addRow("", string);
			android.location.Location loc = ls.getLastKnownLocation(string);
			if(loc != null){
				addRow("Provider: ", string);
				addRow("Speed: ", loc.getSpeed());
				addRow("Bearing: ", loc.getBearing());
				addRow("Altitude: ", loc.getAltitude());
				addRow("Latitude: ", loc.getLatitude());
				addRow("Longitude: ", loc.getLongitude());
				addRow("Accuracy: ", loc.getAccuracy());
				addRow("", "");
			}
		}
	}

	public void addRow(String label, int value) {
		addRow(label, String.valueOf(value));
	}
	public void addRow(String label, float value) {
		addRow(label, String.valueOf(value));
	}
	public void addRow(String label, double value) {
		addRow(label, String.valueOf(value));
	}
	public void addRow(String label, String value) {
		LinearLayout linearLayout = new LinearLayout(getApplicationContext());
		linearLayout.setOrientation(LinearLayout.HORIZONTAL);
		
		TextView textLabelName = new TextView(getApplicationContext());
		textLabelName.setText(label+" ");
		textLabelName.setTextAppearance(getApplicationContext(), android.R.style.TextAppearance_Medium);
		
		TextView textName = new TextView(getApplicationContext());
		
		textName.setText(value);
		
		linearLayout.addView(textLabelName);
		linearLayout.addView(textName);
		
		layout.addView(linearLayout);
	}
	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		doStuff();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		layout.removeAllViews();
	}
	
	
}
