package com.example.a7minworkout

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class HistoryTableDBHelper (context: Context, factory: SQLiteDatabase.CursorFactory?):SQLiteOpenHelper(context,DATABASE_NAME,factory,DATABASE_VERSION) {
    companion object {
        private const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "HistoryTable.db"
        private const val TABLE_NAME = "EXERCISE_HISTORY"
        private const val COLUMN_NAME = "DATES"
        private const val COLUMN_ID = "_id"


    }

    override fun onCreate(db: SQLiteDatabase?) {
        val createTable = ("CREATE TABLE $TABLE_NAME ($COLUMN_ID INTEGER PRIMARY KEY, $COLUMN_NAME TEXT)")
        db?.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)

    }

    fun addDates(date: String) {
        var db = this.writableDatabase
        val value = ContentValues()
        value.put(COLUMN_NAME,date)
        db.insert(TABLE_NAME, null, value)
    }

    fun getAllDates(): ArrayList<String> {
        var db = this.readableDatabase
        var Dates = ArrayList<String>()
        var mycursor = db.rawQuery("SELECT * FROM $TABLE_NAME", null)
        while (mycursor.moveToNext()) {
            var date = mycursor.getString(mycursor.getColumnIndex(COLUMN_NAME))
            Dates.add(date)
        }
        return Dates
    }
}





