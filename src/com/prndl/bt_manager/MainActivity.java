package com.prndl.bt_manager;

import java.io.IOException;

import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // set delay
        try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} // wait 15 seconds between crash
        
        // crash
        try {
			Runtime.getRuntime().exec("service call bluetooth_manager 1");
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
}
