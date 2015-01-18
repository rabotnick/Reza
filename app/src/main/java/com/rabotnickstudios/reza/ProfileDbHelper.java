package com.rabotnickstudios.reza;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class ProfileDbHelper extends SQLiteOpenHelper {
    public static final String TABLE_NAME = "profile";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_EMAIL = "email";
    public static final String COLUMN_PHONE= "phone";
    public static final String COLUMN_ADDRESS = "address";
    public static final String COLUMN_RECRUITER = "false";
    public static final String COLUMN_JOBSEEKER = "false";
    public static final String COLUMN_EDUCATION = "education";
    public static final String COLUMN_SKILL = "skill";
    public static final String COLUMN_EXPERIENCE = "experience";
    public static final String COLUMN_CERTIFICATION = "certification";
    public static final String COLUMN_LANGUAGE = "language";
    private static final String TEXT_TYPE = "TEXT";
    private static final String COMMA_SEP = ",";


    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + TABLE_NAME;
    // If you change the databse schema, you must increment the database version.
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Profile.db";

    public ProfileDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_ENTRIES = "CREATE TABLE `profile` (\n" +
                "\t`name`\tTEXT,\n" +
                "\t`email`\tTEXT,\n" +
                "\t`phone`\tTEXT,\n" +
                "\t'address'\tTEXT,\n" +
                "\t'education'\tTEXT,\n" +
                "\t'skill'\tTEXT,\n" +
                "\t'experience'\tTEXT,\n" +
                "\t'certification'\tTEXT,\n" +
                "\t'language'\tTEXT,\n" +
                "\tPRIMARY KEY(name)\n" +
                ");";
        db.execSQL(SQL_CREATE_ENTRIES);

    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
}
