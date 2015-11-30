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

import com.android.sessionManager.ConnectionsAsync;
import com.example.parser.JSONParser;
import com.interviewtest.utility.Animal;
import com.interviewtest.utility.Constants;
import com.interviewtest.utility.OnTaskCompleted;
import com.interviewtest.utility.ServerUrl;

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
							 LinearLayout layout = (LinearLayout) findViewById(R.id.linear);
							
							    for (Animal localAnimal :JSONParser.getInstance().animalList) {
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
							        imageView.setId(id);
							        imageView.setPadding(2, 2, 2, 2);
							        imageView.setImageBitmap(mIcon_val);
							        imageView.setScaleType(ScaleType.FIT_XY);
							        layout.addView(imageView);
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
