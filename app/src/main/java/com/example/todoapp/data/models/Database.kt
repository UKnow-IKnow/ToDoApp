package com.example.todoapp.data.models

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [ToDoTask::class], version = 1, exportSchema = false)
abstract class Database : RoomDatabase() {
    abstract fun toDoDao(): ToDoDao
}