package com.prndl.bt_manager;

import android.app.IntentService;
import android.content.Intent;
import android.widget.Toast;

public class Crash extends IntentService {

	public Crash() {
		super("\\. ./");
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		Toast.makeText(this, "next round", Toast.LENGTH_SHORT).show();
		
		Intent i = new Intent(this, MainActivity.class);
		i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		startActivity(i);
	    
	    return super.onStartCommand(intent,flags,startId);
	}

	@Override
	protected void onHandleIntent(Intent intent) {
		// TODO Auto-generated method stub
		
	}

}
