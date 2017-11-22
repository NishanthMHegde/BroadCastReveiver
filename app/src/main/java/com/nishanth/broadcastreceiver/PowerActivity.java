package com.nishanth.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class PowerActivity extends AppCompatActivity {
    private static final String TAG = "PowerActivity";
    BroadcastReceiver powerreceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if(intent.getAction()== Intent.ACTION_POWER_CONNECTED){
                Toast.makeText(PowerActivity.this,"Power ON",Toast.LENGTH_SHORT).show();
            }
            else if(intent.getAction()== Intent.ACTION_POWER_DISCONNECTED){
                Log.i(TAG, "onReceive: POWER OFF");
                Toast.makeText(PowerActivity.this,"Power OFF",Toast.LENGTH_SHORT).show();
            }

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_power);
        this.registerReceiver(powerreceiver,new IntentFilter(Intent.ACTION_POWER_CONNECTED));
        this.registerReceiver(powerreceiver,new IntentFilter(Intent.ACTION_POWER_DISCONNECTED));
    }
}
