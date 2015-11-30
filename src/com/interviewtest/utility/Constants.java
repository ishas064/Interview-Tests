package com.interviewtest.utility;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;

public class Constants {
	public static final String EMPTY_STRING = "";

	public static final String NETWORK_UNAVAILABLE_ERROR = "Cannot connect to Internet. You must have network connectivity to use Meeting App";
	public static final String NETWORK_TIMEOUT = "Cannot connect to Server. Request timed out";
	public static Context appContext;
	public static Activity currentActivity;
	public static final String serverIP="192.168.10.104/";

	public static void isDebugging(String Message, String Output) {
		if (Message != null) {
			if (Output != null) {
				Log.v(Constants.currentActivity + " " + Message, "" + Output);
			}
		}
	}

	public static void dialog(String message, Context context) {
		final AlertDialog alertDialog = new AlertDialog.Builder(context).create();
		alertDialog.setTitle("Alert Dialog");
		alertDialog.setMessage(message);
		alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				alertDialog.dismiss();
			}
		});
		alertDialog.show();
	}
}
