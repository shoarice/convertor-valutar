package org.sma.bigbrother;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class BigBrother extends Activity {
    	
    private OnClickListener batteryListener = new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			Intent batteryIntent = new Intent(BigBrother.this, Battery.class);
			startActivity(batteryIntent);
		}
	};
    
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
                      
        Button Battery = (Button) findViewById(R.id.Battery);
        Button Network = (Button) findViewById(R.id.Network);
        Button Sensors = (Button) findViewById(R.id.Sensors);
        Button Processes = (Button) findViewById(R.id.Processes);
        Button Telephony = (Button) findViewById(R.id.Telephony);
        Button Location = (Button) findViewById(R.id.Location);
        Button Log = (Button) findViewById(R.id.Log);
        Button About = (Button) findViewById(R.id.About); 
       
        Battery.setOnClickListener(batteryListener);
        
       
	
	
      
        
    }
}