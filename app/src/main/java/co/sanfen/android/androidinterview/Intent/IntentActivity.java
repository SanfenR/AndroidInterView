package co.sanfen.android.androidinterview.Intent;

import android.content.Intent;
import android.provider.AlarmClock;
import android.provider.CalendarContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import co.sanfen.android.androidinterview.R;

public class IntentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("IntentActivity");
        setContentView(R.layout.activity_intent);
    }

    public void onViewClick(View view) {
        switch (view.getId()) {
            case R.id.btn_set_alarm:

                Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM)
                        .putExtra(AlarmClock.EXTRA_MESSAGE, "起床")
                        .putExtra(AlarmClock.EXTRA_HOUR, 16)
                        .putExtra(AlarmClock.EXTRA_MINUTES, 30);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }

                break;
            case R.id.btn_add_calendar:
                Intent intentCale = new Intent(Intent.ACTION_INSERT)
                        .setData(CalendarContract.Events.CONTENT_URI)
                        .putExtra(CalendarContract.Events.TITLE, "清明节")
                        .putExtra(CalendarContract.Events.EVENT_LOCATION, "北京")
                        .putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, System.currentTimeMillis())
                        .putExtra(CalendarContract.EXTRA_EVENT_END_TIME, System.currentTimeMillis() + 24 * 3600 * 1000);
                if (intentCale.resolveActivity(getPackageManager()) != null) {
                    startActivity(intentCale);
                }

                break;
        }
    }
}
