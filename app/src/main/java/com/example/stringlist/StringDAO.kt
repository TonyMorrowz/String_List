package com.example.stringlist

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface StringDAO {


    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addString(stringItem: StringItem)

    @Update
    suspend fun updateString(stringItem: StringItem)

    @Delete
    suspend fun deleteString(stringItem: StringItem)

    @Query("DELETE FROM string_table")
    suspend fun deleteAllStrings()

    @Query("SELECT * FROM string_table ORDER BY id ASC")
    fun readAllData(): LiveData<List<StringItem>>

}