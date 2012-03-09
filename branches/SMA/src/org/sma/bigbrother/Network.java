package org.sma.bigbrother;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.DetailedState;
import android.net.TrafficStats;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Network extends Activity {
	
	LinearLayout layout;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.network);
		ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
		 layout = (LinearLayout) findViewById(R.id.network_layout);
		//TOTAL
		
		TextView total_rx_bytes = (TextView) findViewById(R.id.TextView05);
		TextView total_tx_bytes = (TextView) findViewById(R.id.TextView08);
		TextView total_rx_packets = (TextView) findViewById(R.id.TextView07);
		TextView total_tx_packets = (TextView) findViewById(R.id.TextView09);
		
		total_rx_bytes.setText(String.valueOf(TrafficStats.getTotalRxBytes()));
		total_tx_bytes.setText(String.valueOf(TrafficStats.getTotalTxBytes()));
		total_rx_packets.setText(String.valueOf(TrafficStats.getTotalRxPackets()));
		total_tx_packets.setText(String.valueOf(TrafficStats.getTotalTxPackets()));
		
		//MOBILE
		
		NetworkInfo info = cm.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
		DetailedState state = info.getDetailedState();
		
		TextView mobileState = (TextView) findViewById(R.id.textViewMobileState);
		mobileState.setText(state.name());
		
		TextView total_rx_bytes_mobile = (TextView) findViewById(R.id.TextView15);
		TextView total_tx_bytes_mobile = (TextView) findViewById(R.id.TextView12);
		TextView total_rx_packets_mobile = (TextView) findViewById(R.id.TextView13);
		TextView total_tx_packets_mobile = (TextView) findViewById(R.id.TextView11);
		
		total_rx_bytes_mobile.setText(String.valueOf(TrafficStats.getMobileRxBytes()));
		total_tx_bytes_mobile.setText(String.valueOf(TrafficStats.getMobileTxBytes()));
		total_rx_packets_mobile.setText(String.valueOf(TrafficStats.getMobileRxPackets()));
		total_tx_packets_mobile.setText(String.valueOf(TrafficStats.getMobileTxPackets()));
		
		
		//WIFI
		WifiManager wifiManager = (WifiManager) getSystemService(WIFI_SERVICE);
		WifiInfo wifiInfo = wifiManager.getConnectionInfo();
		
		TextView ip = (TextView) findViewById(R.id.textViewIP);
		TextView mac = (TextView) findViewById(R.id.textViewMac);
		TextView speed = (TextView) findViewById(R.id.textViewSpeed);
		
		int ipAddress = wifiInfo.getIpAddress();
		String ipS = String.format("%d.%d.%d.%d",
				(ipAddress & 0xff),
				(ipAddress >> 8 & 0xff),
				(ipAddress >> 16 & 0xff),
				(ipAddress >> 24 & 0xff));
		ip.setText(ipS);
		speed.setText(wifiInfo.getLinkSpeed() + " " + WifiInfo.LINK_SPEED_UNITS);
		mac.setText(wifiInfo.getMacAddress());
		
		info = cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
		state = info.getDetailedState();
		
		TextView wifiState = (TextView) findViewById(R.id.textViewWiFiState);
		wifiState.setText(state.name());
		
		TextView total_rx_bytes_wifi = (TextView) findViewById(R.id.TextView26);
		TextView total_tx_bytes_wifi = (TextView) findViewById(R.id.TextView27);
		TextView total_rx_packets_wifi = (TextView) findViewById(R.id.TextView28);
		TextView total_tx_packets_wifi = (TextView) findViewById(R.id.TextView29);

		total_rx_bytes_wifi.setText(String.valueOf(TrafficStats.getTotalRxBytes() - TrafficStats.getMobileRxBytes()));
		total_tx_bytes_wifi.setText(String.valueOf(TrafficStats.getTotalTxBytes() - TrafficStats.getMobileTxBytes()));
		total_rx_packets_wifi.setText(String.valueOf(TrafficStats.getTotalRxPackets() - TrafficStats.getMobileRxPackets()));
		total_tx_packets_wifi.setText(String.valueOf(TrafficStats.getTotalTxPackets() - TrafficStats.getMobileTxPackets()));
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
}


/*ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
NetworkInfo[] info = cm.getAllNetworkInfo();

Log.d(NOTIFICATION_SERVICE, String.valueOf(Proxy.getPort(getApplicationContext())));


for (int i = 0; i<info.length;i++)
{
	Log.d(NOTIFICATION_SERVICE, "Tipul retelei:");
	Log.d(NOTIFICATION_SERVICE, info[i].getTypeName());
	
	if (info[i].isAvailable())
		Log.d(NOTIFICATION_SERVICE, "Se poate sa te conectezi la net");
	else 
		Log.d(NOTIFICATION_SERVICE, "NU se poate sa te conectezi la net");
	
}*/