package com.example.abdulrahman.project9;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context) {
        super(context, ItemContact.DBName, null, ItemContact.version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(ItemContact.CreateDB);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("Drop Table " + ItemContact.DBTable);
        onCreate(db);
    }
}
