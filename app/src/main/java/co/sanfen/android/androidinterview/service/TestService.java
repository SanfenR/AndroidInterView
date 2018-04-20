package co.sanfen.android.androidinterview.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class TestService extends Service {
    private static final String TAG = "TestService";

    int mStartMode;
    IBinder mBinder;
    boolean mAllowRebind;

    public TestService() {
    }

    @Override
    public void onCreate() {
        Log.e(TAG, "onCreate");
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e(TAG, "onStartCommand");
        return mStartMode;
    }
    @Override
    public IBinder onBind(Intent intent) {
        Log.e(TAG, "onBind");
        return mBinder;
    }
    @Override
    public boolean onUnbind(Intent intent) {
        Log.e(TAG, "onUnbind");
        return mAllowRebind;
    }
    @Override
    public void onRebind(Intent intent) {
        Log.e(TAG, "onRebind");
    }
    @Override
    public void onDestroy() {
        Log.e(TAG, "onDestroy");
    }
}
