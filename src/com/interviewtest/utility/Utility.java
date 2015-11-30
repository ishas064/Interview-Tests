package com.interviewtest.utility;
import android.content.Context;
import android.net.ConnectivityManager;

public class Utility {
	/**
	 * Method to determine if network connectivity is available
	 * 
	 * @return true if network connectivity available
	 */
	public static boolean isNetworkAvailable() {
		if (Constants.appContext != null) {
			ConnectivityManager conMgr = (ConnectivityManager) Constants.appContext.getSystemService(Context.CONNECTIVITY_SERVICE);
			boolean connected = (conMgr.getActiveNetworkInfo() != null && conMgr.getActiveNetworkInfo().isAvailable() && conMgr
					.getActiveNetworkInfo().isConnected());
			if (!connected) {
				return false;
			}
			return true;
		}
		return true;
	}

}
