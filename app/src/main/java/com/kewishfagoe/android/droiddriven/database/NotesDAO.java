package com.kewishfagoe.android.droiddriven.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.kewishfagoe.android.droiddriven.entity.Note;

/**
 * Created by Kewish Fagoe on 2/21/2016.
 */
public class NotesDAO extends SQLiteOpenHelper {


    public static final String NOTES_TABLE = "notes";
    public static final String NOTES_TITLE = "title";
    public static final String NOTES_DESCRIPTION = "description";
    private static final String DATABASE_NAME = "notes.db";
    private static final int DATABASE_VERSION = 1;
    private static final String SQL_NOTES_TABLE_QUERY = "CREATE TABLE notes(id INTEGER PRIMARY KEY, title VARCHAR NOT NULL, description STRING NOT NULL)";


    public NotesDAO(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    private void setDefaultCredentials() {

        //insert default notes
        ContentValues contentValues = new ContentValues();
        contentValues.put(NOTES_TITLE, "Do this!");
        contentValues.put(NOTES_DESCRIPTION, "Prepare for Java and Database Exam.");
        insertOneRecord(NOTES_TABLE, contentValues);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_NOTES_TABLE_QUERY);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


    public long insertOneRecord(String tableName, ContentValues contentValues) {
        SQLiteDatabase db = getWritableDatabase();
        long rowId = db.insert(tableName, null, contentValues);
        db.close();
        //return the row ID of the newly inserted row, or -1 if an error occurred
        return rowId;
    }


    public Note findAllRecords(String username) {
        Note note = null;
        SQLiteDatabase db = getReadableDatabase();
        String sql = String.format("select * from %s", NOTES_TABLE);
        Cursor cursor = db.rawQuery(sql, null);
        if (cursor.moveToFirst()) {
            note = new Note(cursor.getInt(0), cursor.getString(1), cursor.getString(2));
        }
        db.close();
        return note;
    }


}
