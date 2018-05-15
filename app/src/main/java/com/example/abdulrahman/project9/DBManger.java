package com.example.abdulrahman.project9;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;

public class DBManger {
    private DBHelper helper;

    public DBManger(Context context) {
        helper = new DBHelper(context);
    }

    public long insert(ContentValues values) {
        SQLiteDatabase database = helper.getWritableDatabase();
        long i = database.insert(ItemContact.DBTable, null, values);
        return i;
    }

    public Cursor allData() {
        SQLiteDatabase database = helper.getWritableDatabase();
        Cursor cursor = database.query(ItemContact.DBTable, null, null, null, null, null, ItemContact.CoulnID);
        return cursor;
    }

    public Cursor displayItem(int id) {
        SQLiteDatabase database = helper.getWritableDatabase();
        String selection = ItemContact.CoulnID + " =" + id;
        //String [] Arrgs={""}
        Cursor cursor = database.query(ItemContact.DBTable, null, selection, null, null, null, ItemContact.CoulnID);
        return cursor;
    }

    public void deleetAll() {
        SQLiteDatabase database = helper.getWritableDatabase();
        database.delete(ItemContact.DBTable, null, null);

    }

    public long update(ContentValues values, int id) {
        SQLiteDatabase database = helper.getWritableDatabase();
        long i = database.update(ItemContact.DBTable, values, ItemContact.CoulnID + "=" + id, null);
        return i;
    }

    public long delte(int id) {
        SQLiteDatabase database = helper.getWritableDatabase();
        long i = database.delete(ItemContact.DBTable, ItemContact.CoulnID + "=" + id, null);
        return i;
    }
}
