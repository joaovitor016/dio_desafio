package br.com.dio.todolist.database

import android.content.ContentValues
import br.com.dio.todolist.model.Task


fun DataBase.salvarDados(item: Task): Long {

   val idTask = writableDatabase.insert("TB_SAVE_INFO", null, ContentValues().apply {
        put("TITLE", item.title)
        put("DATA", item.date)
        put("HOUR", item.hour)

    })

    return idTask
}

fun DataBase.selecionarDados(): List<Task>{

    val sql = "SELECT * FROM TB_SAVE_INFO"

    val cursor = readableDatabase.rawQuery(sql, null)
    val dadosList = mutableListOf<Task>()

    if(cursor.count > 0){

        while (cursor.moveToNext()){

            val task = Task(
                id = cursor.getInt(cursor.getColumnIndex("ID")),
                title = cursor.getString(cursor.getColumnIndex("TITLE")),
                date = cursor.getString(cursor.getColumnIndex("DATE")),
                hour = cursor.getString(cursor.getColumnIndex("HOUR"))

            )
            dadosList.add(task)
        }
    }

    cursor.close()
    return  dadosList
}