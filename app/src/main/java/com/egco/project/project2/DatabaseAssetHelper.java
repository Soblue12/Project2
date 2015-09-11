package com.egco.project.project2;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

/**
 * Created by Bream on 11/9/2558.
 */
public class DatabaseAssetHelper extends SQLiteAssetHelper {

    private static final String DATABASE_NAME = "Blind.db";
    private static final int DATABASE_VERSION = 1;


    public DatabaseAssetHelper(Context context) {
        super(context, DATABASE_NAME, null,DATABASE_VERSION);
    }

    public Cursor getItem() {

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor resource = db.rawQuery("select * from item_table", null);
        resource.moveToFirst();
        return resource;

    }
}
