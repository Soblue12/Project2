package com.egco.project.project2;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class Language extends AppCompatActivity {

    MediaPlayer soundChooseLang;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language);

        soundChooseLang = MediaPlayer.create(Language.this, R.raw.langselection);
        soundChooseLang.start();

        Button thButton = (Button)findViewById(R.id.thButton);
        thButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent height_th = new Intent(getApplicationContext(), height_th.class);
                startActivity(height_th);
                onChange();

                
            }
        });

        Button enButton = (Button)findViewById(R.id.enButton);
        enButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent height_en = new Intent(getApplicationContext(), Height.class);
                startActivity(height_en);
                onChange();
            }
        });
    }

    public void onChange() {
        soundChooseLang.stop();
        soundChooseLang.release();
        soundChooseLang = null;
    }

    public void onDestroy() {
        super.onDestroy();
        soundChooseLang.stop();
        soundChooseLang.release();
        soundChooseLang = null;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_language, menu);
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
