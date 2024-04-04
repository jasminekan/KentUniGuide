package com.example.kentuniguide;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.List;
import java.util.ArrayList;
import android.database.Cursor;

public class MyDatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "my_database";
    private static final int DATABASE_VERSION = 3;

    // Offices table
    private static final String TABLE_OFFICES = "offices";
    private static final String COLUMN_OFFICE_ROOM_NUMBER = "room_number";
    private static final String COLUMN_OFFICE_FLOOR = "floor";
    private static final String COLUMN_OFFICE_FIRST_NAME = "first_name";
    private static final String COLUMN_OFFICE_LAST_NAME = "last_name";

    // Rooms table
    private static final String TABLE_ROOMS = "rooms";
    private static final String COLUMN_ROOM_ROOM_CODE = "room_code";
    private static final String COLUMN_ROOM_FLOOR = "floor";

    // Courses table
    private static final String TABLE_COURSES = "courses";
    private static final String COLUMN_COURSES_MODULE_CODE = "module_code";
    private static final String COLUMN_COURSES_MODULE_NAME = "module_name";
    private static final String COLUMN_COURSES_CONVENOR_NAME = "convenor_name";
    private static final String COLUMN_COURSES_CONVENOR_EMAIL = "convenor_email";
    private static final String COLUMN_COURSES_MODULE_DESCRIPTION = "module_description";

    // Create Offices table SQL statement
    private static final String CREATE_TABLE_OFFICES =
            "CREATE TABLE " + TABLE_OFFICES + " (" +
                    COLUMN_OFFICE_ROOM_NUMBER + " INTEGER PRIMARY KEY, " +
                    COLUMN_OFFICE_FLOOR + " TEXT, " +
                    COLUMN_OFFICE_FIRST_NAME + " TEXT, " +
                    COLUMN_OFFICE_LAST_NAME + " TEXT)";

    // Create Rooms table SQL statement
    private static final String CREATE_TABLE_ROOMS =
            "CREATE TABLE " + TABLE_ROOMS + " (" +
                    COLUMN_ROOM_ROOM_CODE + " TEXT PRIMARY KEY, " +
                    COLUMN_ROOM_FLOOR + " TEXT)";

    // Create Courses table SQL statement
    private static final String CREATE_TABLE_COURSES =
            "CREATE TABLE " + TABLE_COURSES + " (" +
                    COLUMN_COURSES_MODULE_CODE + " TEXT PRIMARY KEY, " +
                    COLUMN_COURSES_MODULE_NAME + " TEXT," +
                    COLUMN_COURSES_CONVENOR_NAME + " TEXT," +
                    COLUMN_COURSES_CONVENOR_EMAIL + " TEXT," +
                    COLUMN_COURSES_MODULE_DESCRIPTION + " TEXT)";

    public MyDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create Offices and Rooms tables
        db.execSQL(CREATE_TABLE_OFFICES);
        db.execSQL(CREATE_TABLE_ROOMS);
        db.execSQL(CREATE_TABLE_COURSES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older tables if they exist
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_OFFICES);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ROOMS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_COURSES);
        // Create tables again
        onCreate(db);
    }

    // Method to add office
    public void addOffice(int roomNumber, int floor, String firstName, String lastName) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_OFFICE_ROOM_NUMBER, roomNumber);
        values.put(COLUMN_OFFICE_FLOOR, floor);
        values.put(COLUMN_OFFICE_FIRST_NAME, firstName);
        values.put(COLUMN_OFFICE_LAST_NAME, lastName);
        db.insert(TABLE_OFFICES, null, values);
    }

    // Method to add room
    public void addRoom(String roomCode, int floor) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ROOM_ROOM_CODE, roomCode);
        values.put(COLUMN_ROOM_FLOOR, floor);
        db.insert(TABLE_ROOMS, null, values);
    }

    // Method to add courses
    public void addCourses(String moduleCode, String moduleName, String convenorName, String convenorEmail, String moduleDescription) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_COURSES_MODULE_CODE, moduleCode);
        values.put(COLUMN_COURSES_MODULE_NAME, moduleName);
        values.put(COLUMN_COURSES_CONVENOR_NAME, convenorName);
        values.put(COLUMN_COURSES_CONVENOR_EMAIL, convenorEmail);
        values.put(COLUMN_COURSES_MODULE_DESCRIPTION, moduleDescription);
        db.insert(TABLE_COURSES, null, values);
    }

    // Method to retrieve convenor names and emails from the database
    public List<String> getConvenors() {
        List<String> convenors = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT DISTINCT " + COLUMN_COURSES_CONVENOR_NAME + ", " + COLUMN_COURSES_CONVENOR_EMAIL + " FROM " + TABLE_COURSES, null);
        if (cursor != null) {
            while (cursor.moveToNext()) {
                String convenorName = cursor.getString(cursor.getColumnIndex(COLUMN_COURSES_CONVENOR_NAME));
                String convenorEmail = cursor.getString(cursor.getColumnIndex(COLUMN_COURSES_CONVENOR_EMAIL));
                convenors.add(convenorName + " (" + convenorEmail + ")");
            }
            cursor.close();
        }
        return convenors;
    }
    // Add a method to get course details
    public List<String> getCourseDetails() {
        List<String> courseDetails = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT " + COLUMN_COURSES_MODULE_CODE + ", " + COLUMN_COURSES_MODULE_NAME + ", " + COLUMN_COURSES_CONVENOR_NAME + ", " + COLUMN_COURSES_MODULE_DESCRIPTION + " FROM " + TABLE_COURSES, null);
        if (cursor.moveToFirst()) {
            do {
                String moduleCode = cursor.getString(cursor.getColumnIndex(COLUMN_COURSES_MODULE_CODE));
                String moduleName = cursor.getString(cursor.getColumnIndex(COLUMN_COURSES_MODULE_NAME));
                String convenorName = cursor.getString(cursor.getColumnIndex(COLUMN_COURSES_CONVENOR_NAME));
                String moduleDescription = cursor.getString(cursor.getColumnIndex(COLUMN_COURSES_MODULE_DESCRIPTION));
                // Concatenate the details into a single string and add to the list
                String courseDetail = moduleCode + " - " + moduleName + " (Convenor: " + convenorName + ")\nDescription: " + moduleDescription;
                courseDetails.add(courseDetail);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return courseDetails;
    }

    // Method to retrieve module information from the database based on module name
    public Module getModule(String moduleCode) {
        SQLiteDatabase db = this.getReadableDatabase();
        Module module = null;
        Cursor cursor = db.query(TABLE_COURSES, null, COLUMN_COURSES_MODULE_CODE + "=?", new String[]{moduleCode}, null, null, null);
        if (cursor != null && cursor.moveToFirst()) {
            String moduleName = cursor.getString(cursor.getColumnIndex(COLUMN_COURSES_MODULE_NAME));
            String convenorName = cursor.getString(cursor.getColumnIndex(COLUMN_COURSES_CONVENOR_NAME));
            String convenorEmail = cursor.getString(cursor.getColumnIndex(COLUMN_COURSES_CONVENOR_EMAIL));
            String description = cursor.getString(cursor.getColumnIndex(COLUMN_COURSES_MODULE_DESCRIPTION));
            module = new Module(moduleCode, moduleName, convenorName, convenorEmail, description);
            cursor.close();
        }
        db.close();
        return module;
    }



}

