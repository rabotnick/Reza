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
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;


public class GeneralSection extends ActionBarActivity {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Profile.db";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general_section);
        final EditText nameField = (EditText)findViewById(R.id.editName);
        final EditText emailField = (EditText)findViewById(R.id.editEmail);
        final EditText phoneField = (EditText)findViewById(R.id.editPhone);
        final EditText addressField = (EditText)findViewById(R.id.editAddress);

        final CheckBox recruiter = (CheckBox)findViewById(R.id.recruiter);
        final CheckBox jobSeeker = (CheckBox)findViewById(R.id.jobSeeker);

        Button button = (Button)findViewById(R.id.nextButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ProfileDbHelper mDbHelper = new ProfileDbHelper(getApplicationContext());
                SQLiteDatabase db = mDbHelper.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put(ProfileDbHelper.COLUMN_NAME, nameField.getText().toString());
                values.put(ProfileDbHelper.COLUMN_EMAIL, emailField.getText().toString());
                values.put(ProfileDbHelper.COLUMN_PHONE, phoneField.getText().toString());
                values.put(ProfileDbHelper.COLUMN_ADDRESS, addressField.getText().toString());
                values.put(ProfileDbHelper.COLUMN_RECRUITER,
                        Boolean.toString(recruiter.isChecked()));
                values.put(ProfileDbHelper.COLUMN_JOBSEEKER,
                        Boolean.toString(jobSeeker.isChecked()));

                db.insert(
                        ProfileDbHelper.TABLE_NAME,
                        null,
                        values);
                Toast.makeText(getApplicationContext(), "Success?", Toast.LENGTH_SHORT).show();

                Intent i = new Intent(getApplicationContext(), EducationSection.class);
                startActivity(i);
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_general_section, menu);
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
