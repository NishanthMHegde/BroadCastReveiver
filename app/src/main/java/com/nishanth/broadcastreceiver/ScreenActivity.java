package com.nishanth.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class ScreenActivity extends AppCompatActivity {
    private static final String TAG = "ScreenActivity";
    BroadcastReceiver screenReceiver =new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if(intent.getAction() == Intent.ACTION_SCREEN_ON){
                Log.i(TAG, "onReceive: Screen is ON");
            }
            else if (intent.getAction() == Intent.ACTION_SCREEN_OFF){
                Log.i(TAG, "onReceive: Screen is OFF");
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen);
        this.registerReceiver(screenReceiver,new IntentFilter(Intent.ACTION_SCREEN_OFF));
        this.registerReceiver(screenReceiver,new IntentFilter(Intent.ACTION_SCREEN_ON));
    }
}
