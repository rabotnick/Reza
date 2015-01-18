package com.rabotnickstudios.reza;

import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.io.File;


public class MainActivity extends ActionBarActivity {

    /* String path = Environment.getExternalStorageDirectory().getAbsolutePath() +
            "/Android/data/myapp/files/myrezaprofile.txt";

    boolean exists = (new File(path)).exists();
    */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        boolean exists = getApplicationContext().getDatabasePath("Profile.db").exists();
        if(!exists) {
            Intent i = new Intent(getApplicationContext(), NewProfile.class);
            startActivity(i);
        } else {
            Intent i = new Intent(getApplicationContext(), NewAction.class);
            startActivity(i);
        }
        /* super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), NewResume.class);
                startActivity(i);
            }
        });

        Button button2 = (Button)findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), CreatedResume.class);
                startActivity(i);
            }
        }); */

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
