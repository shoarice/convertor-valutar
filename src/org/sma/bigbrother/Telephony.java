package org.sma.bigbrother;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.telephony.CellLocation;
import android.telephony.NeighboringCellInfo;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Telephony extends Activity {
	
	TelephonyManager tm;
	LinearLayout layout;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.telephony);
		
		layout = (LinearLayout) findViewById(R.id.telephony_layout);
		
			
		//doStuff();
		
	}
	
	
	
	@Override
	protected void onResume() {
		super.onResume();
		doStuff();
	}


	@Override
	protected void onPause() {
		super.onPause();
		layout.removeAllViews();
	}



	private void doStuff() {
		tm = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
		
		int dataActivity = tm.getDataActivity();
		int dataState = tm.getDataState();
		
		int networkType = tm.getNetworkType();
		int phoneType = tm.getPhoneType();
		
		String imei = tm.getDeviceId();
		String countryIso = tm.getNetworkCountryIso();
		String MCCMNC = tm.getSimOperator();
		String oper = tm.getSimOperatorName();
		String serial = tm.getSimSerialNumber();
		String imsi = tm.getSubscriberId();
		boolean roaming = tm.isNetworkRoaming();
		
		addRow("IMEI: ", imei);
		addRow("IMSI: ", imsi);
		addRow("Operator: ", oper);
		addRow("MCC+MNC: ", MCCMNC);
		addRow("Country ISO: ", countryIso);
		addRow("SIM Serial Number: ", serial);
		addRow("Roaming: ", String.valueOf(roaming));
		
		addRow(" ", " ");
		
		addRow("Phone Type: ", getPhoneType(phoneType));
		addRow("Network Type: ", getNetworkType(networkType));
		addRow("Data State: ", getDataState(dataState));
		addRow("Data Activity: ", getDataActivity(dataActivity));
		
		addRow(" ", " ");
		
		CellLocation cell = tm.getCellLocation();
		if(cell != null){
			addRow("Primary Cell: ", "");
			GsmCellLocation gsmCell;
			CdmaCellLocation cdmaCell;
			if(cell instanceof GsmCellLocation){
				gsmCell = (GsmCellLocation) cell;
				
				addRow("Cell id: ", gsmCell.getCid());
				addRow("Location area code: ", gsmCell.getLac());
				addRow("Primary scrambling code: ", gsmCell.getPsc());
			}
			else{
				cdmaCell = (CdmaCellLocation) cell;
				
				addRow("Base station id: ", cdmaCell.getBaseStationId());
				addRow("Base station Latitude: ", cdmaCell.getBaseStationLatitude());
				addRow("Base station Longitude: ", cdmaCell.getBaseStationLongitude());
				addRow("CDMA network identification number: ", cdmaCell.getNetworkId());
				addRow("CDMA system identification number: ", cdmaCell.getSystemId());
			}
		}
		
		addRow(" ", " ");
		List<NeighboringCellInfo> list = tm.getNeighboringCellInfo();
		if(list != null){
			addRow("Cells in range:", "");
			for (NeighboringCellInfo n : list) {
				addRow("Cell id: ", n.getCid());
				addRow("Network Type: ", getNetworkType(n.getNetworkType()));
				int asu = n.getRssi();
				int s = -113 + 2*asu;
				addRow("Signal strength (dBm): ", s);
				addRow("", "");
			}
		}

	}
	public void addRow(String label, int value) {
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
	public String getDataActivity(int type){
		switch (type) {
		case TelephonyManager.DATA_ACTIVITY_DORMANT:
			return "DORMANT";
		case TelephonyManager.DATA_ACTIVITY_IN:
			return "IN";
		case TelephonyManager.DATA_ACTIVITY_INOUT:
			return "INOUT";
		case TelephonyManager.DATA_ACTIVITY_NONE:
			return "NONE";
		case TelephonyManager.DATA_ACTIVITY_OUT:
			return "OUT";
		default:
			return "UNKNOWN";
		}
	}
	public String getDataState(int type){
		switch (type) {
		case TelephonyManager.DATA_CONNECTED:
			return "CONNECTED";
		case TelephonyManager.DATA_CONNECTING:
			return "CONNECTING";
		case TelephonyManager.DATA_DISCONNECTED:
			return "DISCONNECTED";
		case TelephonyManager.DATA_SUSPENDED:
			return "SUSPENDED";
		default:
			return "UNKNOWN";
		}
	}
	public String getPhoneType(int type){
		switch (type) {
		case TelephonyManager.PHONE_TYPE_CDMA:
			return "CDMA";
		case TelephonyManager.PHONE_TYPE_GSM:
			return "GSM";
		case TelephonyManager.PHONE_TYPE_NONE:
			return "NONE";
		default:
			return "UNKNOWN";
		}
	}
	private String getNetworkType(int type){
		 
		  switch(type){
		  case TelephonyManager.NETWORK_TYPE_UNKNOWN:
		   return "UNKNOWN";
		  case TelephonyManager.NETWORK_TYPE_GPRS:
		   return "GPRS";
		  case TelephonyManager.NETWORK_TYPE_EDGE:
		   return "EDGE";
		  case TelephonyManager.NETWORK_TYPE_UMTS:
		   return "UMTS";
		  case TelephonyManager.NETWORK_TYPE_HSDPA:
		   return "HSDPA";
		  case TelephonyManager.NETWORK_TYPE_HSUPA:
		   return "HSUPA";
		  case TelephonyManager.NETWORK_TYPE_HSPA:
		   return "HSPA";
		  case TelephonyManager.NETWORK_TYPE_CDMA:
		   return "CDMA";
		  case TelephonyManager.NETWORK_TYPE_EVDO_0:
		   return "EVDO 0";
		  case TelephonyManager.NETWORK_TYPE_EVDO_A:
		   return "EVDO A";
		  case TelephonyManager.NETWORK_TYPE_EVDO_B:
		  return "EVDO B";
		  case TelephonyManager.NETWORK_TYPE_1xRTT:
		   return "1xRTT";
		  case TelephonyManager.NETWORK_TYPE_IDEN:
		   return "IDEN";
		 
		  default:
		   return "UNKNOWN";
		  
		  }
		 }
}
