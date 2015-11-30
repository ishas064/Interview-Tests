package com.example.parser;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.interviewtest.utility.Animal;
import com.interviewtest.utility.Bird;
import com.interviewtest.utility.Flag;
import com.interviewtest.utility.Flowers;
import com.interviewtest.utility.Fruit;
import com.interviewtest.utility.Technology;
import com.interviewtest.utility.Vegetables;




public class JSONParser 
{
	 public ArrayList<Animal> animalList;
	 public ArrayList<Bird> birdList;
	 public ArrayList<Flag> flagList;
	 public ArrayList<Flowers> flowersList;
	 public ArrayList<Fruit> fruitList;
	 public ArrayList<Vegetables> vegetablesList;
	 public ArrayList<Technology> techList;

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
			JSONArray vegetablesDetailArray= animalobject.getJSONArray("vegetables");
			
			
			
			
			animalList=new ArrayList<Animal>();
			birdList=new ArrayList<Bird>();
			flagList=new ArrayList<Flag>();
			flowersList= new ArrayList<Flowers>();
			vegetablesList=new ArrayList<Vegetables>();
			techList= new ArrayList<Technology>();
			fruitList = new  ArrayList<Fruit>();
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
			for(int j=0;j<flagDetailArray.length();j++)
			{
				Flag flag=new Flag();
				JSONObject flagObj=flagDetailArray.getJSONObject(j);
				if(flagObj.has("name"))
				{
					flag.FlagName=flagObj.getString("name");
				}
				if(flagObj.has("imgURL"))
				{
					flag.imageUrl=flagObj.getString("imgURL");
				}
				flagList.add(flag);
			}
			for(int j=0;j<flowersDetailArray.length();j++)
			{
				Flowers flower=new Flowers();
				JSONObject flowerObj=flowersDetailArray.getJSONObject(j);
				if(flowerObj.has("name"))
				{
					flower.flowerName=flowerObj.getString("name");
				}
				if(flowerObj.has("imgURL"))
				{
					flower.imageUrl=flowerObj.getString("imgURL");
				}
				flowersList.add(flower);
			}
			for(int j=0;j<flowersDetailArray.length();j++)
			{
				Flowers flower=new Flowers();
				JSONObject flowerObj=flowersDetailArray.getJSONObject(j);
				if(flowerObj.has("name"))
				{
					flower.flowerName=flowerObj.getString("name");
				}
				if(flowerObj.has("imgURL"))
				{
					flower.imageUrl=flowerObj.getString("imgURL");
				}
				flowersList.add(flower);
			}
			for(int j=0;j<fruitsDetailArray.length();j++)
			{
				Fruit fruit=new Fruit();
				JSONObject fruitObj=fruitsDetailArray.getJSONObject(j);
				if(fruitObj.has("name"))
				{
					fruit.fruitName=fruitObj.getString("name");
				}
				if(fruitObj.has("imgURL"))
				{
					fruit.imageUrl=fruitObj.getString("imgURL");
				}
				fruitList.add(fruit);
			}
			for(int j=0;j<vegetablesDetailArray.length();j++)
			{
				Vegetables veg=new Vegetables();
				JSONObject vegObj=vegetablesDetailArray.getJSONObject(j);
				if(vegObj.has("name"))
				{
					veg.vegName=vegObj.getString("name");
				}
				if(vegObj.has("imgURL"))
				{
					veg.imageUrl=vegObj.getString("imgURL");
				}
				vegetablesList.add(veg);
			}
			for(int j=0;j<technologyDetailArray.length();j++)
			{
				Technology tech=new Technology();
				JSONObject techObj=technologyDetailArray.getJSONObject(j);
				if(techObj.has("name"))
				{
					tech.techName=techObj.getString("name");
				}
				if(techObj.has("imgURL"))
				{
					tech.imageUrl=techObj.getString("imgURL");
				}
				techList.add(tech);
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
