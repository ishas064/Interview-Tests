package com.example.ishainterviewtest;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.sessionManager.ConnectionsAsync;
import com.example.parser.JSONParser;
import com.interviewtest.utility.Animal;
import com.interviewtest.utility.Bird;
import com.interviewtest.utility.Constants;
import com.interviewtest.utility.OnTaskCompleted;
import com.interviewtest.utility.ServerUrl;
import com.interviewtest.utility.Technology;
import com.interviewtest.utility.Vegetables;

public class BaseActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_base);
		ConnectionsAsync viewSetting = new ConnectionsAsync(BaseActivity.this,
				new OnTaskCompleted() {
					@Override
					public void onTaskFailed(String message) {
						Constants.dialog(message, BaseActivity.this);
					}

					@Override
					public void onTaskCompleted(Object responseobject) {
						boolean status=JSONParser.getInstance().getAnimalDetail(responseobject.toString());
						if(status)
						{
							int id=0;
							 LinearLayout layout = (LinearLayout) findViewById(R.id.animal);
							// TextView animalName = (TextView) findViewById(R.id.text1);
							    for (Animal localAnimal :JSONParser.getInstance().animalList) {
							    	//if(id==0)
							    	//{
							    	//	animalName.setText(localAnimal.animalName);
							    	//}
							    	URL newurl = null;
									try {
										newurl = new URL(ServerUrl.getInstance().getImageprotocal()+localAnimal.imageUrl);
									} catch (MalformedURLException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									} 
									Bitmap mIcon_val = null;
									try {
										mIcon_val = BitmapFactory.decodeStream(newurl.openConnection() .getInputStream());
									} catch (IOException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									id++;
							        ImageView imageView = new ImageView(BaseActivity.this);
							       RelativeLayout.LayoutParams lparams= new RelativeLayout.LayoutParams(70,70);
							        imageView.setId(id);
							        imageView.setPadding(2, 2, 2, 2);
							        imageView.setImageBitmap(mIcon_val);
							        imageView.setScaleType(ScaleType.FIT_XY);
							        imageView.setLayoutParams(lparams);
							        layout.addView(imageView);
							    }
							    LinearLayout linear = (LinearLayout) findViewById(R.id.bird);
							    for (Bird localbBird :JSONParser.getInstance().birdList) {
							    	URL newurl = null;
									try {
										newurl = new URL(ServerUrl.getInstance().getImageprotocal()+localbBird.imageUrl);
									} catch (MalformedURLException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									} 
									Bitmap mIcon_val = null;
									try {
										mIcon_val = BitmapFactory.decodeStream(newurl.openConnection() .getInputStream());
									} catch (IOException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									id++;
							        ImageView imageView = new ImageView(BaseActivity.this);
							       RelativeLayout.LayoutParams lparams= new RelativeLayout.LayoutParams(70,70);
							        imageView.setId(id);
							        imageView.setPadding(2, 2, 2, 2);
							        imageView.setImageBitmap(mIcon_val);
							        imageView.setScaleType(ScaleType.FIT_XY);
							        imageView.setLayoutParams(lparams);
							        linear.addView(imageView);
							    }
							    
							    LinearLayout veg = (LinearLayout) findViewById(R.id.veg);
							    for (Vegetables VegBird :JSONParser.getInstance().vegetablesList) {
							    	URL newurl = null;
									try {
										newurl = new URL(ServerUrl.getInstance().getImageprotocal()+VegBird.imageUrl);
									} catch (MalformedURLException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									} 
									Bitmap mIcon_val = null;
									try {
										mIcon_val = BitmapFactory.decodeStream(newurl.openConnection() .getInputStream());
									} catch (IOException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									id++;
							        ImageView imageView = new ImageView(BaseActivity.this);
							       RelativeLayout.LayoutParams lparams= new RelativeLayout.LayoutParams(70,70);
							        imageView.setId(id);
							        imageView.setPadding(2, 2, 2, 2);
							        imageView.setImageBitmap(mIcon_val);
							        imageView.setScaleType(ScaleType.FIT_XY);
							        imageView.setLayoutParams(lparams);
							        veg.addView(imageView);
							    }
							    LinearLayout Tech = (LinearLayout) findViewById(R.id.tech);
							    for (Technology techBird :JSONParser.getInstance().techList) {
							    	URL newurl = null;
									try {
										newurl = new URL(ServerUrl.getInstance().getImageprotocal()+techBird.imageUrl);
									} catch (MalformedURLException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									} 
									Bitmap mIcon_val = null;
									try {
										mIcon_val = BitmapFactory.decodeStream(newurl.openConnection() .getInputStream());
									} catch (IOException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									id++;
							        ImageView imageView = new ImageView(BaseActivity.this);
							       RelativeLayout.LayoutParams lparams= new RelativeLayout.LayoutParams(70,70);
							        imageView.setId(id);
							        imageView.setPadding(2, 2, 2, 2);
							        imageView.setImageBitmap(mIcon_val);
							        imageView.setScaleType(ScaleType.FIT_XY);
							        imageView.setLayoutParams(lparams);
							        Tech.addView(imageView);
							    }
						}
					}

					@Override
					public void onTaskCompleted() {
						// TODO Auto-generated method stub

					}

					@Override
					public void onTaskFailed() {
						// TODO Auto-generated method stub

					}
				});

		viewSetting.execute();

	}

}
