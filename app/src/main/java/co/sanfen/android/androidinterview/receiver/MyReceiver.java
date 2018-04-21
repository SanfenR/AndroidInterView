package co.sanfen.android.androidinterview.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * @author MZ
 * @email sanfenruxi1@163.com
 * @date 2018/4/21.
 */

public class MyReceiver extends BroadcastReceiver {
    public static final String FILTER = "co.sanfen.android.androidinterview.receiver.MyReceiver";

    private static final String TAG = "MyReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        String name = intent.getStringExtra("name");
        Log.e(TAG, "onReceive: " + name);
    }
}
