package co.sanfen.android.androidinterview.contentprovider;

import android.Manifest;
import android.content.ContentResolver;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import co.sanfen.android.androidinterview.R;

public class CpActivity extends AppCompatActivity {

    ListView list;

    ContentResolver cr;

    private List<Map<String, Object>> data;
    private SimpleAdapter sa;

    String[] permissions = new String[]{
            Manifest.permission.READ_CONTACTS
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cp);
    }

    @Override
    public void onContentChanged() {
        super.onContentChanged();
        setTitle("ContentProvider");
        list = findViewById(R.id.lv_content);
        cr = getContentResolver();
        data = new ArrayList<>();
        sa = new SimpleAdapter(this, data, android.R.layout.simple_list_item_2, new String[]{"names", "phones"}, new int[]{android.R.id
                .text1, android.R.id.text2});
        list.setAdapter(sa);

        ActivityCompat.requestPermissions(this, permissions, 1000);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == 1000) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                getContent();
            }
        }
    }

    public void getContent() {
        Cursor cursor = cr.query(Uri.parse("content://com.android.contacts/raw_contacts"), null, null, null, null);
        while (cursor != null && cursor.moveToNext()) {
            Map<String, Object> map = new HashMap<>();
            int id = cursor.getColumnIndex("_id");
            String displayName = cursor.getString(cursor.getColumnIndex("display_name"));
            Log.i("test", id + displayName);
            map.put("names", displayName);

            //根据联系人获取联系人数据
            Cursor cursor2 = cr.query(Uri.parse("content://com.android.contacts/raw_contacts/" + id + "/data"), null, null, null, null);
            while (cursor2 != null && cursor2.moveToNext()) {
                //  int type=cursor2.getInt(cursor2.getColumnIndex("mimetype_id"));
                String type = cursor2.getString(cursor2.getColumnIndex("mimetype"));
                String data1 = null;
                if ("vnd.android.cursor.item/phone_v2".equals(type)) {
                    data1 = cursor2.getString(cursor2.getColumnIndex("data1"));
                    Log.i("test", "   " + type + " " + data1);
                    map.put("phones", data1);
                }
            }
            if (cursor2 != null)
                cursor2.close();
            data.add(map);
            //通知适配器发生改变
            sa.notifyDataSetChanged();
        }
        if (cursor != null)
            cursor.close();
    }
}
