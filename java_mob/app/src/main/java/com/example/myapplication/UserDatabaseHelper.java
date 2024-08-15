package com.example.myapplication;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class UserDatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "user.db";
    private static final int DATABASE_VERSION = 1;

    public UserDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE users (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "username TEXT, " +
                "password TEXT, " +
                "email TEXT, " +
                "gender TEXT, " +
                "country TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS users");
        onCreate(db);
    }


    /* *This method will return the data that you can then log.
       *Add a Method to Retrieve Data
        public Cursor getAllUsers() {
            SQLiteDatabase db = this.getReadableDatabase();
            return db.query(
                    "users",           // The table to query
                    null,              // The columns to return
                    null,              // The columns for the WHERE clause
                    null,              // The values for the WHERE clause
                    null,              // Group the rows
                    null,              // Filter by row groups
                    null               // The sort order
            );
        }

     */
}
