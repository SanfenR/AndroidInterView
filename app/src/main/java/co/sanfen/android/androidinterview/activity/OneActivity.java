package co.sanfen.android.androidinterview.activity;

import android.content.Intent;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import co.sanfen.android.androidinterview.R;

public class OneActivity extends AppCompatActivity {

    public EditText mPwdEt;
    public String PWD_CACHE = "pwd_cache";

    private static final String TAG = "OneActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(TAG, "onCreate");
        setContentView(R.layout.activity_one);
        setTitle(TAG);
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.e(TAG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG, "onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e(TAG, "onRestart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy");
    }


    @Override
    public void onContentChanged() {
        super.onContentChanged();
        Log.e(TAG, "onContentChanged");
        mPwdEt = findViewById(R.id.password);
    }

    @Override
    public void onPostCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onPostCreate(savedInstanceState, persistentState);
        Log.e(TAG, "onPostCreate");
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        Log.e(TAG, "onPostResume");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.e(TAG, "onSaveInstanceState");
        outState.putString(PWD_CACHE, String.valueOf(mPwdEt.getText()));
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.e(TAG, "onRestoreInstanceState");
        String pwd = savedInstanceState.getString(PWD_CACHE);
        mPwdEt.setText(String.format("restore:%s", pwd));
    }

    public void jumpTwo(View view) {
        Intent intent = new Intent(this, TwoActivity.class);
        startActivity(intent);
    }
}
