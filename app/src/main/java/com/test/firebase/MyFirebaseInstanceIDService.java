package com.test.firebase;

import android.content.Context;
import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;
import com.test.firebase.utils.Constants;
import com.test.firebase.utils.DevicePreferences;

/**
 * Created by sikander on 25/10/16.
 */
public class MyFirebaseInstanceIDService extends FirebaseInstanceIdService {

    Context context;

    private static final String TAG = "MyFirebaseIIDService";

    @Override
    public void onTokenRefresh() {

        //Getting registration token
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();

        //Displaying token on logcat
        Log.d(TAG, "Refreshed token: " + refreshedToken);

        sendRegistrationToServer(refreshedToken);

    }

    private void sendRegistrationToServer(String token)
    {

        new DevicePreferences().addKey(this, Constants.FIREBASE_TOKEN, token);

        //You can implement this method to store the token on your server
        //Not required for current project
    }


}