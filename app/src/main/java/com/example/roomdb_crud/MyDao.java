package com.example.roomdb_crud;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface MyDao {
    @Insert
     void addData(MyDataList myDataList);

    @Query("select * from mydatalist")
     List<MyDataList> getMyData();

    @Update
     void updateData(MyDataList myDataList);

    @Delete
     void deleteData(MyDataList myDataList);



}
