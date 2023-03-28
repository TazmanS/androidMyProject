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

    fun findItem(id: Int): ToDoItem? {
        return data.find {
            it.id == id
        }
    }

    fun updateItem(toDoItem: ToDoItem) {
        val index = data.indexOf(data.find { it.id == toDoItem.id })
        if (index != -1) {
            data[index] = toDoItem
        }

    }
}