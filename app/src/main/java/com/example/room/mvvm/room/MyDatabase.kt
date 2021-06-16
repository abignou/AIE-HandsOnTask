package com.example.room.mvvm.room

import android.content.Context
import androidx.room.*
import com.example.room.mvvm.model.DepTableModel
import com.example.room.mvvm.model.EmpTableModel

@Database(entities = arrayOf(EmpTableModel::class, DepTableModel::class), version = 1, exportSchema = false)
abstract class MyDatabase : RoomDatabase() {

    abstract fun myDao() : DAOAccess

    companion object {

        @Volatile
        private var INSTANCE: MyDatabase? = null


        fun getDataseClient(context: Context) : MyDatabase {

            if (INSTANCE != null) return INSTANCE!!

            synchronized(this) {

                INSTANCE = Room
                    .databaseBuilder(context, MyDatabase::class.java, "My_DATABASE")
                    .fallbackToDestructiveMigration()
                    .build()

                return INSTANCE!!

            }
        }


    }

}