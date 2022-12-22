package com.example.ToDoAplicationOdev.room;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.ToDoAplicationOdev.data.entity.Notlar;


@Database(entities = {Notlar.class},version = 1)
public abstract class VeriTabani extends RoomDatabase {
    public abstract NotlarDao getNotlarDao();
}
