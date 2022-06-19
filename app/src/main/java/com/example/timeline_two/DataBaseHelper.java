package com.example.timeline_two;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataBaseHelper extends SQLiteOpenHelper {
    public DataBaseHelper(@Nullable Context context) {
        super(context, "Login.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase myDatabase) {
        myDatabase.execSQL("create Table users(individual_id INTEGER PRIMARY KEY AUTOINCREMENT,username Text,fullname Text, email Text, phoneNumber Text,address Text,password Text,day Text)");

        myDatabase.execSQL("create Table timeline(timeline_id INTEGER PRIMARY KEY AUTOINCREMENT,fullname Text,content Text,date_post Text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public Boolean insertData(String username,String fullName,String email,String phoneNumber,String address,String password,String day){
        SQLiteDatabase myDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("username",username);
        values.put("fullName",fullName);
        values.put("email",email);
        values.put("phoneNumber",phoneNumber);
        values.put("address",address);
        values.put("password",password);
        values.put("day",day);

        long check = myDatabase.insert("users",null,values);
        if(check == -1){
            return false;
        }
        else {
            return true;
        }
    }

    public void updateIndividual(String username,String fullName,String email,String phoneNumber,String address,String individual_id){
        SQLiteDatabase myDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("username",username);
        values.put("fullName",fullName);
        values.put("email",email);
        values.put("phoneNumber",phoneNumber);
        values.put("address",address);

        myDatabase.update("users",values,"individual_id =?", new String[] {String.valueOf(individual_id)});
    }

    public Cursor loginCheck(String userName, String pass) {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();

        Cursor checkData = sqLiteDatabase.rawQuery("SELECT * FROM users WHERE username = ? and password =?", new String[]{userName, pass});
        return checkData;
    }

    public void contentAdd(String fullName,String desc,String date){
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("fullname", fullName);
        values.put("content", desc);
        values.put("date_post", date);

        database.insert("timeline", null, values);
    }


    public Cursor allPosts(){
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "Select * from timeline order by timeline_id desc";
        Cursor data=db.rawQuery(sql,null);
        return data;
    }







}
