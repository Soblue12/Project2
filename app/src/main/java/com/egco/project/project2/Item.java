package com.egco.project.project2;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class Item extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);


        ImageView setting = (ImageView)findViewById(R.id.settingButton);
        ListView listView1 = (ListView)findViewById(R.id.listView1);

        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Setting_in = new Intent(getApplicationContext(),Setting.class);
                startActivity(Setting_in);
            }
        });

        String[] myItem = new String[]{
                "bed","tv","chair","lecture chair","projector","projector screen"
        };


        ArrayAdapter<String> mAdapter = new ArrayAdapter<String>(this, R.layout.custom_list, myItem);


        CustomListAdapter customListAdapter = new CustomListAdapter(this, R.layout.custom_list, myItem);

        listView1.setAdapter(customListAdapter);


    }

    //test comment

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_item, menu);
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

