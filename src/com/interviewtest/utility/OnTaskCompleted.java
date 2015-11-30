package com.interviewtest.utility;

public interface OnTaskCompleted {

	void onTaskCompleted();

	void onTaskFailed();

	void onTaskFailed(String message);

	void onTaskCompleted(Object responseobject);
}
