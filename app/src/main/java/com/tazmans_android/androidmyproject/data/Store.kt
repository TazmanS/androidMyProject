package com.tazmans_android.androidmyproject.data

object Store {
    var data = mutableListOf<ToDoItem>(
        ToDoItem(
            id = 0,
            title = "title111",
            description = "description2222"
        )
    )

    fun addItem(newItem: ToDoItem) {
        data.add(newItem)
    }
}