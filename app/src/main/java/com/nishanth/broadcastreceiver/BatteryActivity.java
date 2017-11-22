package com.nishanth.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class BatteryActivity extends AppCompatActivity {
            TextView battery;
            BroadcastReceiver batteryreceiver = new BroadcastReceiver() {
                @Override
                public void onReceive(Context context, Intent intent) {
                    int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL,0);
                    battery.setText("Battery: " + level + " %");
                }
            };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battery);
        battery = (TextView)findViewById(R.id.battery);
        this.registerReceiver(batteryreceiver,new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
    }
}
