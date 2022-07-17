package com.example.stringlist

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [StringItem::class], version = 1, exportSchema = false)
abstract class StringDatabase : RoomDatabase() {

    abstract fun stringDAO(): StringDAO

    companion object {
        @Volatile
        private var INSTANCE: StringDatabase? = null

        fun getDatabase(context: Context): StringDatabase{
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    StringDatabase::class.java,
                    "string_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }

}
