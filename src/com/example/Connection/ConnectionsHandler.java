package com.example.Connection;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.http.util.ByteArrayBuffer;

import com.interviewtest.utility.Constants;
import com.interviewtest.utility.Utility;



public class ConnectionsHandler {
	/* Constants to indicate request type */
	private final String GET = "GET";
	private final String POST = "POST";

	/**
	 * Message used in case of any failure
	 */
	public String erroredResponseMessage;

	/**
	 * Singleton instance of ConnectionsHandler class
	 */
	private static ConnectionsHandler instance;

	/**
	 * Constructor
	 */
	private ConnectionsHandler() {
	}

	/**
	 * Used to get instance of this class
	 * 
	 * @return instance of ConnectionsHandler
	 */
	public static ConnectionsHandler getInstance() {
		if (instance == null) {
			instance = new ConnectionsHandler();
		}
		return instance;
	}

	/**
	 * Method to connect to the provided URL and get the response data
	 * 
	 * @param urlString
	 *            URL to be connected
	 * @return Response data
	 */
	public String getNetworkData(String urlString) {
		if (!Utility.isNetworkAvailable()) {
			erroredResponseMessage = Constants.NETWORK_UNAVAILABLE_ERROR;
			return null;
		}
		urlString = urlString.replaceAll(" ", "%20");
		try {
			URL url = new URL(urlString);
			HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
			urlConnection.setRequestMethod(GET);
			urlConnection.setDoOutput(false);
			urlConnection.setDoInput(true);
			urlConnection.setConnectTimeout(60000);
			urlConnection.setReadTimeout(60000);
			urlConnection.connect();

			int responseCode = urlConnection.getResponseCode();
			if (responseCode == HttpURLConnection.HTTP_OK) {
				erroredResponseMessage = Constants.EMPTY_STRING;
				InputStream is = urlConnection.getInputStream();
				BufferedInputStream bis = new BufferedInputStream(is, 512);
				ByteArrayBuffer baf = new ByteArrayBuffer(512);
				int current = 0;
				while ((current = bis.read()) != -1) {
					baf.append((byte) current);
				}

				String response = new String(baf.toByteArray(), "UTF8");
				is.close();
				urlConnection.disconnect();

				return response;
			} else if (responseCode == -1) {
				erroredResponseMessage = Constants.NETWORK_TIMEOUT;
			} else if (responseCode >= 500) {
				erroredResponseMessage = "Cannot connect to Titbit";
			} else {
				erroredResponseMessage = urlConnection.getResponseMessage();
			}
		} catch (Exception e) {

			erroredResponseMessage = "Cannot connect to Titbit.";
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Method used to send POST requests to provided URL
	 * 
	 * @param urlString
	 * @param data
	 *            Data to be POSTed
	 * @return Response obtained from the server
	 */
	public String postDataRequest(String urlString, String data) {
		try {
			URL url = new URL(urlString);
			HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
			urlConnection.setRequestMethod(POST);
			urlConnection.setDoOutput(true);
			urlConnection.setConnectTimeout(30000);
			urlConnection.setReadTimeout(30000);
			urlConnection.setRequestProperty("Content-type", "text/xml; charset=" + "UTF-8");

			OutputStream outputStream = urlConnection.getOutputStream();
			outputStream.write(data.getBytes("UTF8"));
			outputStream.close();

			int responseCode = urlConnection.getResponseCode();
			if (responseCode == HttpURLConnection.HTTP_OK) {
				InputStream is = urlConnection.getInputStream();

				BufferedInputStream bis = new BufferedInputStream(is, 512);
				ByteArrayBuffer baf = new ByteArrayBuffer(512);
				int current = 0;
				while ((current = bis.read()) != -1) {
					baf.append((byte) current);
				}
				String response = new String(baf.toByteArray(), "UTF8");
				is.close();
				urlConnection.disconnect();

				return response;
			} else {
				erroredResponseMessage = urlConnection.getResponseMessage();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
