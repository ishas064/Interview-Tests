package com.example.ishainterviewtest;

import android.app.Activity;
import android.os.Bundle;

import com.android.sessionManager.ConnectionsAsync;
import com.interviewtest.utility.Constants;
import com.interviewtest.utility.OnTaskCompleted;

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
						System.out.println(responseobject.toString());
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
