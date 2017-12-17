package com.example.hassan.hassan;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by hassan on 11/30/17.
 */

public class UserDBHelper extends SQLiteOpenHelper{
    public static final String TABLE_NAME = "users";
    public static final String COL_ID = "id";

    public static final String COL_NAME = "name";
    public static final String COL_EMAIL = "email";
    public static final String COL_MAJOR = "major";
    public static final String COL_ACCEPTED = "accepted";
    public static final String COL_Password = "password";
    public static final String COL_TYPE = "type";



    public static final String DATABASE_NAME = "Users.db";
    public static final int DATABASE_VERSION = 1;
    public static final String SQL_CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " ("
            + COL_ID + " INTEGER PRIMARY KEY, "
            + COL_NAME + " TEXT,"
            + COL_EMAIL + " TEXT,"
            + COL_Password + " TEXT,"
            + COL_MAJOR + " INTEGER,"
            + COL_ACCEPTED + " INTEGER,"
            + COL_TYPE + " INTEGER )";

    public static final String SQL_DELETE_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;


    public UserDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_TABLE);
        ContentValues contentValues=new ContentValues();
        contentValues.put(COL_NAME,"hassan");
        contentValues.put(COL_EMAIL,"hassan@gmail.com");
        contentValues.put(COL_MAJOR,0);
        contentValues.put(COL_Password,"12345");
        contentValues.put(COL_TYPE,0);
        db.insert(TABLE_NAME,null,contentValues);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //delete the old table
        db.execSQL(SQL_DELETE_TABLE);
        db.execSQL(SQL_CREATE_TABLE);
        onCreate(db);
    }

    public void addUser(String name,String email,String password,int major){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COL_NAME,name);
        contentValues.put(COL_EMAIL,email);
        contentValues.put(COL_MAJOR,major);
        contentValues.put(COL_TYPE,1);
        contentValues.put(COL_Password,password);
        db.insert(TABLE_NAME,null,contentValues);
        db.close();
    }

    public void UpdateUser(String name,int id){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put(COL_ACCEPTED,id);
        db.update(TABLE_NAME,contentValues,COL_NAME+" = ?",new String[]{"'"+name+"'"});
        db.close();
    }
    public String isExist(String email,String password){
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME,new String[]{"*"},COL_EMAIL+" = ? AND "+COL_Password+" = ?",new String[]{email,password},null,null,null);
        if (cursor.getCount()==0){
            return "hassan";
        }else {
            cursor.moveToNext();
        }
        return cursor.getString(cursor.getColumnIndex(COL_NAME));

    }
    public int getType(String email){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor=db.query(TABLE_NAME,new String[]{COL_TYPE},COL_EMAIL+" = ?",new String[]{email},null,null,null);
        int type=0;
        while (cursor.moveToNext()) {
            type = cursor.getInt(cursor.getColumnIndex(COL_TYPE));
        }
        db.close();
        return type;
    }
    public ArrayList<String> getUsers(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor=db.rawQuery("Select * from "+TABLE_NAME+" Where "+COL_ACCEPTED+" = 1",null);
        ArrayList<String> users=new ArrayList<>();
        while (cursor.moveToNext()) {
            users.add(cursor.getString(cursor.getColumnIndex(COL_NAME)));
        }
        db.close();
        return users;
    }


}
