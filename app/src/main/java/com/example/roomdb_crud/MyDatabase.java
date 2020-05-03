package com.example.roomdb_crud;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {MyDataList.class},version = 1)
public abstract class MyDatabase extends RoomDatabase {
    public abstract MyDao myDao();
}
