package com.test.firebase;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GetTokenResult;
import com.google.firebase.auth.FirebaseAuth;
import com.test.firebase.utils.Constants;
import com.test.firebase.utils.DevicePreferences;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private Button generateToken;

    private FirebaseAuth.AuthStateListener mAuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById();
        listeners();
    }

    private void findViewById()
    {
        generateToken = (Button) findViewById(R.id.buttonLogin);
    }

    private void listeners()
    {
        generateToken.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firebase_token = new DevicePreferences().getString(MainActivity.this, Constants.FIREBASE_TOKEN);

                Toast.makeText(MainActivity.this, firebase_token, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
//        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    public void onStop() {
        super.onStop();
//        if (mAuthListener != null) {
//            mAuth.removeAuthStateListener(mAuthListener);
//        }
    }
}
