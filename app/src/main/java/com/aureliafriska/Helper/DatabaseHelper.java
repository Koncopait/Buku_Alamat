package com.aureliafriska.Helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.aureliafriska.Model.Data;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "Data.db";

    // User table name
    private static final String TABLE_Data = "List_Data";

    // User Table Columns names
    private static final String COLUMN_Data_Nama = "Nama";
    private static final String COLUMN_Data_Email = "Email";
    private static final String COLUMN_Data_NoHp = "No_Hp";
    private static final String COLUMN_Data_AsalIns = "Asal_Instansi";
    private static final String COLUMN_Data_AlamatIns = "Alamat_Instansi";
    private static final String COLUMN_Data_NoTelp = "No_Telepon";
    private static final String COLUMN_Data_Fax = "No_" +
            "Fax";

    // create table sql query
    private String CREATE_USER_TABLE = "CREATE TABLE " + TABLE_Data + "("
            + COLUMN_Data_Nama + " TEXT," + COLUMN_Data_Email + " TEXT,"
            + COLUMN_Data_NoHp + " TEXT,"+ COLUMN_Data_AsalIns + " TEXT,"+ COLUMN_Data_AlamatIns + " TEXT,"
            + COLUMN_Data_NoTelp + " TEXT," + COLUMN_Data_Fax + " TEXT" + ")";
    // drop table sql query
    private String DROP_USER_TABLE = "DROP TABLE IF EXISTS " + TABLE_Data;

    /**
     * Constructor
     *
     * @param context
     */
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_USER_TABLE);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        //Drop User Table if exist
        db.execSQL(DROP_USER_TABLE);

        // Create tables again
        onCreate(db);

    }

    /**
     * This method is to create user record
     *
     * @param data
     */
    public void addUser(Data data) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_Data_Nama, data.getNama());
        values.put(COLUMN_Data_Email, data.getEmail());
        values.put(COLUMN_Data_NoHp, data.getNoHp());
        values.put(COLUMN_Data_AsalIns, data.getAsalIns());
        values.put(COLUMN_Data_AlamatIns, data.getAlamatIns());
        values.put(COLUMN_Data_NoTelp, data.getNoTelp());
        values.put(COLUMN_Data_Fax, data.getFax());
        // Inserting Row
        db.insert(TABLE_Data, null, values);
        db.close();
    }

    /**
     * This method is to fetch all user and return the list of user records
     *
     * @return list
     */
    public ArrayList<Data> getAllData() {
        // array of columns to fetch
        String[] columns = {
                COLUMN_Data_Nama,
                COLUMN_Data_Email,
                COLUMN_Data_NoHp,
                COLUMN_Data_AsalIns,
                COLUMN_Data_AlamatIns,
                COLUMN_Data_NoTelp,
                COLUMN_Data_Fax
        };
        // sorting orders
        String sortOrder =
                COLUMN_Data_Nama + " ASC";
        ArrayList<Data> userList = new ArrayList<Data>();

        SQLiteDatabase db = this.getReadableDatabase();

        // query the user table
        /**
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT user_id,user_name,user_email,user_password FROM user ORDER BY user_name;
         */
        Cursor cursor = db.query(TABLE_Data, //Table to query
                columns,    //columns to return
                null,        //columns for the WHERE clause
                null,        //The values for the WHERE clause
                null,       //group the rows
                null,       //filter by row groups
                sortOrder); //The sort order


        // Traversing through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Data data = new Data();
                data.setNama(cursor.getString(cursor.getColumnIndex(COLUMN_Data_Nama)));
                data.setEmail(cursor.getString(cursor.getColumnIndex(COLUMN_Data_Email)));
                data.setNoHp(cursor.getString(cursor.getColumnIndex(COLUMN_Data_NoHp)));
                data.setAsalIns(cursor.getString(cursor.getColumnIndex(COLUMN_Data_AsalIns)));
                data.setAlamatIns(cursor.getString(cursor.getColumnIndex(COLUMN_Data_AlamatIns)));
                data.setNoTelp(cursor.getString(cursor.getColumnIndex(COLUMN_Data_NoTelp)));
                data.setFax(cursor.getString(cursor.getColumnIndex(COLUMN_Data_Fax)));

                // Adding user record to list
                userList.add(data);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();

        // return user list
        return userList;
    }

    public void deleteUser() {
        SQLiteDatabase db = this.getWritableDatabase();
        // delete user record by id
        db.delete(TABLE_Data,null,null);
        db.close();
    }

}