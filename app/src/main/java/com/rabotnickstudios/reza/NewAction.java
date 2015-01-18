package com.rabotnickstudios.reza;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class NewAction extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_action);
        /*String name = ProfileDbHelper.getData("COLUMN_NAME");
        TextView text = (TextView)findViewById(R.id.textGreeting);
        text.*/
        Button editProf = (Button)findViewById(R.id.editButton);
        Button sentResumes = (Button)findViewById(R.id.sentButton);
        Button receivedResumes = (Button)findViewById(R.id.receivedButton);
        Button sendResume = (Button)findViewById(R.id.sendButton);

        editProf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /*ProfileDbHelper mDbHelper = new ProfileDbHelper(getApplicationContext());
                SQLiteDatabase db = mDbHelper.getWritableDatabase();
                ContentValues values = new ContentValues();*/
                Intent i = new Intent(getApplicationContext(), EditProfile.class);
                startActivity(i);
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_new_action, menu);
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
