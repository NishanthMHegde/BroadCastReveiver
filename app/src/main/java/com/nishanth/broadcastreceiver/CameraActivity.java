package com.nishanth.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class CameraActivity extends AppCompatActivity {
    private static final String TAG = "CameraActivity";
    BroadcastReceiver cameraReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if(intent.getAction()== Intent.ACTION_CAMERA_BUTTON){
                Log.i(TAG, "onReceive: Photo Clicked");
                
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        this.registerReceiver(cameraReceiver,new IntentFilter(Intent.ACTION_CAMERA_BUTTON));
    }
}
