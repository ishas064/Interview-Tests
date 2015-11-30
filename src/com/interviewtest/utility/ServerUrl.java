package com.interviewtest.utility;


public class ServerUrl {
	private static ServerUrl instance;
	public String protocol = "http://";
	private String imagemaster = "imageData.php";

	public static ServerUrl getInstance() {
		if (instance == null) {
			instance = new ServerUrl();
		}
		return instance;
	}

	public String getImageMasterURL() {

		return (protocol + Constants.serverIP  + imagemaster);
	}

}