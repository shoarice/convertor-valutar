package org.sma.bigbrother;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Log extends Activity {

	private LinearLayout layout;
	private AlertDialog mMainDialog;
	private ProgressDialog mProgressDialog;
    private CollectLogTask mCollectLogTask;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.log);
	
		layout = (LinearLayout) findViewById(R.id.log_layout);
		
		mCollectLogTask = new CollectLogTask();
		mCollectLogTask.execute(null);
/*		try {
			List<String> list = mCollectLogTask.get();
			for (String string : list) {
				addRow("",string);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		
	}
	
	private class CollectLogTask extends AsyncTask<Void, Void, List<String>>{

		@Override
		protected void onPreExecute(){
			showProgressDialog("Loading...");
		}
		 
		@Override
		protected List<String> doInBackground(Void... arg0) {
			ArrayList<String> ret = new ArrayList<String>();
			ArrayList<String> commandLine = new ArrayList<String>();
			commandLine.add("logcat");//$NON-NLS-1$
			commandLine.add("-d");//$NON-NLS-1$
			/*ArrayList<String> arguments = ((params != null) && (params.length > 0)) ? params[0] : null;
	         if (null != arguments){
	             commandLine.addAll(arguments);
	         }*/
			
			Process process;
			try {
				process = Runtime.getRuntime().exec(commandLine.toArray(new String[0]));
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
				
				String line;
				while ((line = bufferedReader.readLine()) != null){
					int i = line.indexOf(':');
					String line1 = line.substring(0, i+1);
					String line2 = line.substring(i+1);
					ret.add(line1);
					ret.add(line2);
					ret.add(" ");
					/*addRow("",line1);
					addRow("",line2);
					addRow("", "");*/
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return ret;
		}
		
		@Override
        protected void onPostExecute(List<String> x){
			dismissProgressDialog();
			for (String string : x) {
				addRow("",string);
			}
			//dismissMainDialog();
			//finish();
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
    
    void showErrorDialog(String errorMessage){
        new AlertDialog.Builder(this)
        .setTitle(getString(R.string.app_name))
        .setMessage(errorMessage)
        .setIcon(android.R.drawable.ic_dialog_alert)
        .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener(){
            @Override
			public void onClick(DialogInterface dialog, int whichButton){
                //finish();
            }
        })
        .show();
    }
    
    void dismissMainDialog(){
        if (null != mMainDialog && mMainDialog.isShowing()){
            mMainDialog.dismiss();
            mMainDialog = null;
        }
    }
    
    void showProgressDialog(String message){
        mProgressDialog = new ProgressDialog(this);
        mProgressDialog.setIndeterminate(true);
        mProgressDialog.setMessage(message);
        mProgressDialog.setCancelable(true);
        mProgressDialog.setOnCancelListener(new DialogInterface.OnCancelListener(){
            @Override
			public void onCancel(DialogInterface dialog){
                cancellCollectTask();
                finish();
            }
        });
        mProgressDialog.show();
    }
    
    private void dismissProgressDialog(){
        if (null != mProgressDialog && mProgressDialog.isShowing())
        {
            mProgressDialog.dismiss();
            mProgressDialog = null;
        }
    }
    
    void cancellCollectTask(){
        if (mCollectLogTask != null && mCollectLogTask.getStatus() == AsyncTask.Status.RUNNING)
        {
            mCollectLogTask.cancel(true);
            mCollectLogTask = null;
        }
	}
	
}
