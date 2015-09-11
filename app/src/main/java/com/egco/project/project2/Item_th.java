package com.egco.project.project2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

public class Item_th extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_th);

        ImageView setting = (ImageView)findViewById(R.id.settingThBut);
        ListView listViewTh = (ListView)findViewById(R.id.listViewTh);

        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Setting_th = new Intent(getApplicationContext(), Setting_th.class);
                startActivity(Setting_th);
            }
        });

        String[] myItem = new String[]{
                "เตียง","โทรทัศน์","เก้าอี้","เก้าอี้เลคเชอร์","โปรเจคเตอร์","จอโปรเจคเตอร์"
        };

       // ArrayAdapter<String> mAdapter = new ArrayAdapter<String>(this, R.layout.custom_list, myItem);

       // CustomListAdapter customListAdapter = new CustomListAdapter(this, R.layout.custom_list, items);
        //listView1.setAdapter();

        //listViewTh.setAdapter(customListAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_item_th, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
