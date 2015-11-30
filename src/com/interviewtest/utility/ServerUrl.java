package com.interviewtest.utility;

public class ServerUrl {
	static ServerUrl intance;
	
	public static ServerUrl getInstance()
	{
		if(intance!=null)
		{
			intance= new ServerUrl();
		}
		return intance;
	}
String imageURl="https://api.twitter.com/1/";

public String getimageURl() {
	// TODO Auto-generated method stub
	return imageURl;
}
}
