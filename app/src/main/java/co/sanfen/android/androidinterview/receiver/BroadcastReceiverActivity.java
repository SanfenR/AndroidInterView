package co.sanfen.android.androidinterview.receiver;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import co.sanfen.android.androidinterview.R;

public class BroadcastReceiverActivity extends AppCompatActivity {

    MyReceiver receiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("BroadcastReceiverActivity");
        setContentView(R.layout.activity_broadcast_receiver);

        findViewById(R.id.btn_send).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(MyReceiver.FILTER);
                intent.putExtra("name", "sanfen");
                getBaseContext().sendBroadcast(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        receiver = new MyReceiver();
        IntentFilter filter = new IntentFilter();
        filter.addAction(MyReceiver.FILTER);
        registerReceiver(receiver,  filter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(receiver);
    }
}
