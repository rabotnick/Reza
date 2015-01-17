package com.rabotnickstudios.reza;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


public class NewResume extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_resume);

        final ArrayList<String> sections = new ArrayList<>();
        sections.add("General Info");
        sections.add("Education");
        sections.add("Skills");
        sections.add("Experience");
        sections.add("Certification(s)");
        sections.add("Language(s)");

        final ListView listview = (ListView) findViewById(R.id.listView);
        final ArrayAdapter adapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1, sections);
        listview.setAdapter(adapter);
        listview.setClickable(true);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final String item = (String) parent.getItemAtPosition(position);
                if (item.equals("General Info")) {
                    Intent i = new Intent(getApplicationContext(), GeneralSection.class);
                    startActivity(i);
                    }
                else if (item.equals("Education")) {
                    Intent i = new Intent(getApplicationContext(), EducationSection.class);
                    startActivity(i);
                }
                else if (item.equals("Skills")) {
                    Intent i = new Intent(getApplicationContext(), SkillSection.class);
                    startActivity(i);
                }
                else if (item.equals("Experience")) {
                    Intent i = new Intent(getApplicationContext(), ExperienceSection.class);
                    startActivity(i);
                }
                else if (item.equals("Certification(s)")) {
                    Intent i = new Intent(getApplicationContext(), CertificationSection.class);
                    startActivity(i);
                }
                else if (item.equals("Language(s)")) {
                    Intent i = new Intent(getApplicationContext(), LanguageSection.class);
                    startActivity(i);
                }
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_new_resume, menu);
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
