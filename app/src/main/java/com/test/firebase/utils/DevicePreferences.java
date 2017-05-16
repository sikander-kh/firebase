package com.test.firebase.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class DevicePreferences {


	public SharedPreferences get(Context context) {
		return context.getSharedPreferences(Constants.PREF_FILE_NAME, Context.MODE_PRIVATE);
	}

	public void addKey(Context context, String key, String value) {
		SharedPreferences settings = get(context);
		SharedPreferences.Editor editor = settings.edit();
		editor.putString(key, value);
		editor.commit();
	}
	
	public String getString(Context context, String key) {
		SharedPreferences prefs = get(context);
		return prefs.getString(key, null);
	}
}
