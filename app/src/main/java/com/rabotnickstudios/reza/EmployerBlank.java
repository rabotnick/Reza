package com.rabotnickstudios.reza;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class EmployerBlank extends ActionBarActivity {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "FeedReader.db";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employer_blank);
        final EditText companyField = (EditText)findViewById(R.id.editText);
        final EditText repField = (EditText)findViewById(R.id.editText2);
        final EditText emailField = (EditText)findViewById(R.id.editText3);

        Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EmployerDbHelper mDbHelper = new EmployerDbHelper(getApplicationContext());
                SQLiteDatabase db = mDbHelper.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put(EmployerDbHelper.COLUMN_NAME_COMPANY, companyField.getText().toString());
                values.put(EmployerDbHelper.COLUMN_NAME_REP, repField.getText().toString());
                values.put(EmployerDbHelper.COLUMN_NAME_EMAIL, emailField.getText().toString());

                db.insert(
                        EmployerDbHelper.TABLE_NAME,
                        null,
                        values);
                Toast.makeText(getApplicationContext(), "Success?", Toast.LENGTH_SHORT).show();
            }
        });
// How you want the results sorted in the resulting Cursor

        //Cursor c=db.rawQuery("SELECT * FROM employer", null);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_employer_blank, menu);
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