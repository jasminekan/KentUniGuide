package com.example.kentuniguide;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
public class Database extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Info_Database";
    public static final Integer DATABASE_VERSION = 2;

    //THE INFORMATION TABLE
    public static final String TABLE_INFORMATION = "Information";
    public static final String COLUMN_QUERY_ID = "query_id";
    public static final String COLUMN_FIRST_NAME = "first_name";
    public static final String COLUMN_LAST_NAME = "last_name";
    public static final String COLUMN_EMAIL = "email";
    public static final String COLUMN_QUERY = "query";
    public static final String COLUMN_INSERT_DATE = "insert_date";


    //This outlines what attributes i want in the database and points out their factors
    private static final String CREATE_TABLE_INFORMATION = "CREATE TABLE "
            + TABLE_INFORMATION + " ("
            + COLUMN_QUERY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_FIRST_NAME + " VARCHAR(60) NOT NULL, "
            + COLUMN_LAST_NAME + " VARCHAR(60) NOT NULL, "
            + COLUMN_EMAIL + " VARCHAR(100) NOT NULL, "
            + COLUMN_QUERY + "TEXT NOT NULL, "
            + COLUMN_INSERT_DATE + "DATETIME DEFAULT CURRENT_TIMESTAMP"
            + ");";

    public Database(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    //this will create the information table
    public void onCreate(SQLiteDatabase db){
        db.execSQL(CREATE_TABLE_INFORMATION);
    }

    //this is to ensure that the database is being updated
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_INFORMATION);
        onCreate(db);
    }

}
