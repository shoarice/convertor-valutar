package org.sma.bigbrother;

import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.List;
import java.util.Scanner;
import java.util.regex.MatchResult;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.Context;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

public class Processes extends Activity {
	private LinearLayout layout;
	ActivityManager am;
	MemoryInfo mi = new MemoryInfo();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.processes);
		
		layout = (LinearLayout) findViewById(R.id.processes_layout);
		
		doStuff();
		
	}

	
	@Override
	protected void onResume() {
		super.onResume();
		//doStuff();
	}


	@Override
	protected void onPause() {
		super.onPause();
		layout.removeAllViews();
	}
	private void doStuff() {
		am = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
		am.getMemoryInfo(mi);
		
		long avMegs = mi.availMem / 1048576L;
		int total = (int) Math.round(getMemoryTotal() * 0.0009765625);
		ProgressBar barMem = (ProgressBar) findViewById(R.id.progressBarMem);
		barMem.setMax(total);
		barMem.setProgress((int)avMegs);
		TextView textMem = (TextView) findViewById(R.id.textViewMem);
		textMem.setText(avMegs +"MB used of "+ total +"MB");
		
		float cpu = readUsage();
		ProgressBar barCpu = (ProgressBar) findViewById(R.id.progressBarCpu);
		barCpu.setMax(100);
		barCpu.setProgress(Math.round(cpu));
		
		TextView textCpu = (TextView) findViewById(R.id.textViewCpu);
		textCpu.setText(String.valueOf(Math.round(cpu)) + " %");
		
		List<ActivityManager.RunningTaskInfo> tasks = am.getRunningTasks(100);
		
		for (RunningTaskInfo runningTaskInfo : tasks) {
			addTaskInfo(runningTaskInfo);
		}
	}
	
	public void addTaskInfo(ActivityManager.RunningTaskInfo ti) {
		
		int i = ti.baseActivity.getShortClassName().lastIndexOf('.');
		String name = ti.baseActivity.getShortClassName().substring(i+1);
		
		addRow("Name:", name);
		if(ti.description != null)
			addRow("Description:", ti.description.toString());
		addRow("# of Activities:", String.valueOf(ti.numActivities));
		addRow("# of Running Activities: ", String.valueOf(ti.numRunning));
		addRow(" ", " ");
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
	
	private float readUsage() {
	    try {
	        RandomAccessFile reader = new RandomAccessFile("/proc/stat", "r");
	        String load = reader.readLine();

	        String[] toks = load.split(" ");

	        long idle1 = Long.parseLong(toks[5]);
	        long cpu1 = Long.parseLong(toks[2]) + Long.parseLong(toks[3]) + Long.parseLong(toks[4])
	              + Long.parseLong(toks[6]) + Long.parseLong(toks[7]) + Long.parseLong(toks[8]);

	        try {
	            Thread.sleep(360);
	        } catch (Exception e) {}

	        reader.seek(0);
	        load = reader.readLine();
	        reader.close();

	        toks = load.split(" ");

	        long idle2 = Long.parseLong(toks[5]);
	        long cpu2 = Long.parseLong(toks[2]) + Long.parseLong(toks[3]) + Long.parseLong(toks[4])
	            + Long.parseLong(toks[6]) + Long.parseLong(toks[7]) + Long.parseLong(toks[8]);

	        return (float)(cpu2 - cpu1) / ((cpu2 + idle2) - (cpu1 + idle1));

	    } catch (IOException ex) {
	        ex.printStackTrace();
	    }

	    return 0;
	} 
	
	private static final String BOGOMIPS_PATTERN = "BogoMIPS[\\s]*:[\\s]*(\\d+\\.\\d+)[\\s]*\n";
	  private static final String MEMTOTAL_PATTERN = "MemTotal[\\s]*:[\\s]*(\\d+)[\\s]*kB\n";
	  private static final String MEMFREE_PATTERN = "MemFree[\\s]*:[\\s]*(\\d+)[\\s]*kB\n";


	  /**
	   * @return in kiloBytes.
	   * @throws SystemUtilsException
	   */
	  public int getMemoryTotal() {
	    MatchResult matchResult = null;
		try {
			matchResult = matchSystemFile("/proc/meminfo", MEMTOTAL_PATTERN, 1000);
		} catch (Exception e1) {
			e1.printStackTrace();
		}

	    try {
	      if(matchResult.groupCount() > 0) {
	        return Integer.parseInt(matchResult.group(1));
	      }
	       else
	       	return 0;
	    } catch (final NumberFormatException e) {
	    	e.printStackTrace();
	    }
		return 0;
	  }

	  private MatchResult matchSystemFile(final String pSystemFile, final String pPattern, final int pHorizon) throws Exception {
	    InputStream in = null;
	    try {
	      final Process process = new ProcessBuilder(new String[] { "/system/bin/cat", pSystemFile }).start();

	      in = process.getInputStream();
	      final Scanner scanner = new Scanner(in);

	      final boolean matchFound = scanner.findWithinHorizon(pPattern, pHorizon) != null;
	      if(matchFound) {
	        return scanner.match();
	      } else {
	        throw new Exception();
	      }
	    } catch (final IOException e) {
	      throw new Exception(e);
	    } 
	      
	  }
}
