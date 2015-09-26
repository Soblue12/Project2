package com.egco.project.project2;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.nfc.NfcAdapter;
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
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Item extends AppCompatActivity {

    private Cursor items;
    private DatabaseAssetHelper db;
    private NfcAdapter mNfcAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);

        //nfc
        mNfcAdapter = NfcAdapter.getDefaultAdapter(this);
        if (mNfcAdapter == null) {
        // Stop here, we definitely need NFC
        Toast.makeText(this, "This device doesn't support NFC.", Toast.LENGTH_LONG).show();
        finish();
        return;

    }
        handleIntent(getIntent());



        //end nfc
        db = new DatabaseAssetHelper(this);
        items = db.getItem();
        if(items.getCount()==0){
            showMessage("no","no data");
            return;
        }

        ArrayList<String> list = new ArrayList<String>();

        while(!items.isAfterLast()){
            list.add(items.getString(1));
            items.moveToNext();
        }

        ImageView setting = (ImageView)findViewById(R.id.settingButton);
        ListView listView1 = (ListView)findViewById(R.id.listView1);

        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Setting_in = new Intent(getApplicationContext(),Setting.class);
                startActivity(Setting_in);
            }
        });


        CustomListAdapter customListAdapter = new CustomListAdapter(this, R.layout.custom_list, list);
        listView1.setAdapter(customListAdapter);

    }

    private void handleIntent(Intent intent) {
        // TODO: handle Intent
    }

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

    public void showMessage(String title,String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();

    }
}

