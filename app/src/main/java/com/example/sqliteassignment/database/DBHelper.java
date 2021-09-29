package com.example.sqliteassignment.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.sql.Date;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "BILL";
    public static final int DB_VERSION = 1;

    public static String TABLE_NAME = "TBL_BILL";
    public static String ID = "_id";
    public static String NAME = "name";
    public static String DESCRIPTION = "description";
    public static String DETAIL = "detail";
    public static double PRICE = Double.parseDouble("total_price");
    public static Date TIME = Date.valueOf("yyyy-MM-dd");
    public static String CATEGORY = "category";

    // Tạo db
    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE " + TABLE_NAME + "("
                + ID + "INTEGER PRIMARY KEY, "
                + NAME + "TEXT, "
                + DESCRIPTION + "TEXT, "
                + DETAIL + "TEXT, "
                + PRICE + "DOUBLE, "
                + TIME + "DATE, "
                + CATEGORY + "TEXT)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS " + TABLE_NAME;
        db.execSQL(sql);
        onCreate(db);
    }

    public String addBill(String name, String description, String detail, double price, Date time, String category) {
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(NAME, name);
        contentValues.put(DESCRIPTION, description);
        contentValues.put(DETAIL, detail);
        contentValues.put(String.valueOf(PRICE), price);
        contentValues.put(String.valueOf(TIME), String.valueOf(time));
        contentValues.put(CATEGORY, category);
        long isAdd = db.insert(TABLE_NAME, null, contentValues);
        if (isAdd == -1) {
            return "Add failed";
        }
        db.close();
        return "Add success";
    }

    public String updateBill(int id, String name, String description, String detail, double price, Date time, String category) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(NAME, name);
        contentValues.put(DESCRIPTION, description);
        contentValues.put(DETAIL, detail);
        contentValues.put(String.valueOf(PRICE), price);
        contentValues.put(String.valueOf(TIME), String.valueOf(time));
        contentValues.put(CATEGORY, category);
        int isUpdate = db.update(TABLE_NAME, contentValues, ID + "=?", new String[]{id + ""});
        if (isUpdate > 0) {
            return "Update success";
        }
        db.close();
        return "Update failed";
    }

    public String deleteBill(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        int isDelete = db.delete(TABLE_NAME, ID + "= ?", new String[]{id + ""});
        if (isDelete > 0) {
            return "Update success";
        }
        db.close();
        return "Update failed";
    }

    public Cursor getAllBill() {
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "SELECT * FROM " + TABLE_NAME;
        Cursor c = db.rawQuery(sql, null);
        return c;
    }
}
