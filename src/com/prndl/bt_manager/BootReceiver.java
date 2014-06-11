package com.prndl.bt_manager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class BootReceiver extends BroadcastReceiver {
	 
    @Override
    public void onReceive(Context context, Intent intent) {
        // error: 06-11 14:39:19.640: W/ActivityManager(22455): Unable to start service Intent { cmp=com.prndl.bt_manager/.MainActivity (has extras) } U=0: not found
        Intent serviceIntent = new Intent(context, com.prndl.bt_manager.MainActivity.class);
		serviceIntent.putExtra("interval", 1 * 1000L);//every second
		context.startService(serviceIntent);
    }
 
}