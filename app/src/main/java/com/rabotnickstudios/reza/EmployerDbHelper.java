package com.rabotnickstudios.reza;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class EmployerDbHelper extends SQLiteOpenHelper {
    public static final String TABLE_NAME = "employer";
    public static final String COLUMN_NAME_COMPANY = "company_name";
    public static final String COLUMN_NAME_REP = "representative_name";
    public static final String COLUMN_NAME_EMAIL = "email_address";
    private static final String TEXT_TYPE = " TEXT";
    private static final String COMMA_SEP = ",";


    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + TABLE_NAME;
    // If you change the databse schema, you must increment the database version.
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Employer.db";

    public EmployerDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_ENTRIES = "CREATE TABLE `employer` (\n" +
                "\t`company_name`\tTEXT,\n" +
                "\t`representative_name`\tTEXT,\n" +
                "\t`email_address`\tTEXT,\n" +
                "\tPRIMARY KEY(company_name)\n" +
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