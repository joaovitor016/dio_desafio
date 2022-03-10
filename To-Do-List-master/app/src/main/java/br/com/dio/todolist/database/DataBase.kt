package br.com.dio.todolist.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DataBase(context: Context): SQLiteOpenHelper(context, "Dados.db", null, 1) {


    override fun onCreate(db: SQLiteDatabase?) {

        val sql = """
            CREATE TABLE TB_SAVE_INFO(
            ID INTEGER PRIMARY KEY AUTOINCREMENT,
            TITLE TEXT,
            DATA TEXT,
            HOUR TEXT
            );
        """.trimIndent()

        db?.execSQL(sql)

    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        db?.execSQL("DROP TABLE IF EXISTS TB_SAVE_INFO")
        onCreate(db)
    }


}