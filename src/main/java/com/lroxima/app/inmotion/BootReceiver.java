package com.lroxima.app.inmotion;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class BootReceiver extends BroadcastReceiver {

    private static final String TAG = "MyActivity";

    public BootReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {

        Log.d(TAG,"Hello World");

            // This is where you start your service
            context.startService(new Intent(context, ActivityRecognizedIntentService.class));

    }
}
