package com.example.eventplanning;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;
public class database2 extends SQLiteOpenHelper {
    public static final String EVENTS_TABLE2 = "EVENTS_TABLE2";
    public static final String COLUMN_EVENT_TYPE = "EVENT_TYPE";    public static final String COLUMN_EVENT_DATE = "EVENT_DATE";
    public static final String COLUMN_EVENT_VEN = "EVENT_VEN";
    public static final String COLUMN_CUSTOMER_ID = "ID";

    public database2(Context context)  {
        super(context, "Event.db", null,1);
    }

    public void onCreate(SQLiteDatabase db1) {
        String createtablestatement= "CREATE TABLE " + EVENTS_TABLE2 + " (" + " integer PRIMARY KEY AUTOINCREMENT," + COLUMN_EVENT_TYPE + " TEXT," + COLUMN_CUSTOMER_ID + "INTEGER," + COLUMN_EVENT_VEN + "TEXT," + COLUMN_EVENT_DATE + " TEXT)";

        db1.execSQL(createtablestatement);

    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {


    }

    public boolean addTwo(EVENTS event) {
        SQLiteDatabase db1 = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_EVENT_TYPE , event.getType());
        cv.put(COLUMN_EVENT_DATE, event.getDate());
        cv.put(COLUMN_EVENT_VEN , event.getVen());
        long insert = db1.insert(EVENTS_TABLE2, null, cv);
        if (insert == -1) {
            return false;
        } else {
            return true;
        }
    }
}
