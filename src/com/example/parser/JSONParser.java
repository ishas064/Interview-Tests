package com.example.parser;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.interviewtest.utility.Animal;
import com.interviewtest.utility.Bird;




public class JSONParser 
{
	 public ArrayList<Animal> animalList;
	 public ArrayList<Bird> birdList;
	static JSONParser instance;
	public static JSONParser getInstance() {
		if (instance == null) {
			instance = new JSONParser();
		}
		return instance;
	}
	public boolean getAnimalDetail(String response) {
		boolean status;
		try {
			JSONObject animalobject= new JSONObject(response);
			JSONArray animalDetailArray= animalobject.getJSONArray("animals");
			JSONArray birdDetailArray= animalobject.getJSONArray("birds");
			JSONArray flagDetailArray= animalobject.getJSONArray("flags");
			JSONArray flowersDetailArray= animalobject.getJSONArray("flowers");
			JSONArray fruitsDetailArray= animalobject.getJSONArray("fruits");
			JSONArray technologyDetailArray= animalobject.getJSONArray("technology");
			JSONArray vegetablesDetailArray= animalobject.getJSONArray("flags");
			
			
			
			
			animalList=new ArrayList<Animal>();
			birdList=new ArrayList<Bird>();
			for(int i=0;i<animalDetailArray.length();i++)
			{
				Animal animal=new Animal();
				JSONObject animalObj=animalDetailArray.getJSONObject(i);
				if(animalObj.has("name"))
				{
					animal.animalName=animalObj.getString("name");
				}
				if(animalObj.has("imgURL"))
				{
					animal.imageUrl=animalObj.getString("imgURL");
				}
				animalList.add(animal);
			}
			for(int j=0;j<birdDetailArray.length();j++)
			{
				Bird bird=new Bird();
				JSONObject birdObj=birdDetailArray.getJSONObject(j);
				if(birdObj.has("name"))
				{
					bird.birdName=birdObj.getString("name");
				}
				if(birdObj.has("imgURL"))
				{
					bird.imageUrl=birdObj.getString("imgURL");
				}
				birdList.add(bird);
			}
			
			status=true;
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			status=false;
		}
		
		
		
		return status;

		
	}

}
