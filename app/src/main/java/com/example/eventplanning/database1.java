package com.example.eventplanning;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class database1 extends SQLiteOpenHelper {


    public static final String CUSTOMER_TABLE1 = "CUSTOMER_TABLE";
    public static final String COLUMN_CUSTOMER_NAME = "CUSTOMER_NAME";
    public static final String COLUMN_CUSTOMER_EMAIL = "CUSTOMER_EMAIL";
    public static final String COLUMN_CUSTOMER_PASSWORD = "CUSTOMER_PASSWORD";
    public static final String COLUMN_ID = "ID";



    public database1(Context context)  {
        super(context, "Customer.db", null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createtablestatement= "CREATE TABLE " + CUSTOMER_TABLE1 + " (" + COLUMN_ID + " integer PRIMARY KEY AUTOINCREMENT," + COLUMN_CUSTOMER_NAME + " TEXT," + COLUMN_CUSTOMER_EMAIL + " TEXT," + COLUMN_CUSTOMER_PASSWORD + " TEXT)";

        db.execSQL(createtablestatement);



    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {


    }
    public boolean addOne(Customers customer) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_CUSTOMER_NAME, customer.getName());
        cv.put(COLUMN_CUSTOMER_EMAIL, customer.getEmail());
        cv.put(COLUMN_CUSTOMER_PASSWORD, customer.getPassword());
        long insert = db.insert(CUSTOMER_TABLE1, null, cv);
        if (insert == -1) {
            return false;
        } else {
            return true;
        }
    }




}