package org.sma.bigbrother;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.net.TrafficStats;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class Network extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.network);
	
		TextView default_host = (TextView) findViewById(R.id.textView6);
		TextView default_port = (TextView) findViewById(R.id.textView7);
		TextView current_host = (TextView) findViewById(R.id.textView8);
		TextView current_port = (TextView) findViewById(R.id.textView9);
		
		default_host.setText(String.valueOf(Proxy.getDefaultHost()));
		default_port.setText(String.valueOf(Proxy.getDefaultPort()));
		current_host.setText(String.valueOf(Proxy.getHost(getBaseContext())));
		current_port.setText(String.valueOf(Proxy.getPort(getBaseContext())));
		
		
		TextView total_rx_bytes = (TextView) findViewById(R.id.TextView05);
		TextView total_tx_bytes = (TextView) findViewById(R.id.TextView08);
		TextView total_rx_packets = (TextView) findViewById(R.id.TextView07);
		TextView total_tx_packets = (TextView) findViewById(R.id.TextView09);
		
		total_rx_bytes.setText(String.valueOf(TrafficStats.getTotalRxBytes()));
		total_tx_bytes.setText(String.valueOf(TrafficStats.getTotalTxBytes()));
		total_rx_packets.setText(String.valueOf(TrafficStats.getTotalRxPackets()));
		total_tx_packets.setText(String.valueOf(TrafficStats.getTotalTxPackets()));
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