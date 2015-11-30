package com.android.sessionManager;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;



import com.example.Connection.ConnectionsHandler;

import com.interviewtest.utility.OnTaskCompleted;
import com.interviewtest.utility.ServerUrl;


public class ConnectionsAsync extends AsyncTask<String, Void, Void> {
	public String response;

	ProgressDialog mProgressDialog;
	OnTaskCompleted listener;
	Context context;

	public ConnectionsAsync(Context context, OnTaskCompleted listener) {
		this.listener = listener;
		this.context = context;
	}

	@Override
	protected Void doInBackground(String... params) {
		
			String url = ServerUrl.getInstance().getImageMasterURL();
			try
			{
			response = ConnectionsHandler.getInstance().getNetworkData(url);
	
			} 
			catch (Exception e)
			{			

			}
			
	
		return null;
	}

	@Override
	protected void onPostExecute(Void result) {
		super.onPostExecute(result);
		mProgressDialog.dismiss();
		if (response != null) {
			listener.onTaskCompleted(response);
		} else {
			listener.onTaskFailed();
		}
	}

	@Override
	protected void onPreExecute() {
		super.onPreExecute();
		mProgressDialog = new ProgressDialog(context);
		mProgressDialog.setMessage("Loading......");
		mProgressDialog.setIndeterminate(true);
		mProgressDialog.setCancelable(false);
		mProgressDialog.show();

	}

}
