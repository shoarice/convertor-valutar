package org.sma.bigbrother;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import android.app.Activity;
import android.os.Bundle;

public class Log extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.log);
		
		File f = new File("/dev/log/main");
		try {
			BufferedReader in = new BufferedReader(new FileReader(f));
			String x = null;
			do{
				 x = in.readLine();
				android.util.Log.d("BB", x);
			}
			while(x != null);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
