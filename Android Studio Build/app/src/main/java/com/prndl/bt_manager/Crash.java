package com.prndl.bt_manager;

import android.app.IntentService;
import android.content.Intent;

public class Crash extends IntentService {

	public Crash() {
		super("\\. ./");
	}
	
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
        Intent i = new Intent(this, MainActivity.class);
		i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		startActivity(i);
	    
	    return super.onStartCommand(intent,flags,startId);
	}

	@Override
	protected void onHandleIntent(Intent intent) {

	}

}
