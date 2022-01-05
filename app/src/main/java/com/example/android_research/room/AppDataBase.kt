package com.example.android_research.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [UserModel::class], version = 1)
abstract class AppDataBase : RoomDatabase() {
    companion object {
        var DATABASE_NAME = "user.db"
        var instance: AppDataBase? = null

        fun getInstance(context: Context): AppDataBase {
            synchronized(this) {
                if (instance == null) {
                    instance = Room.databaseBuilder(context, AppDataBase::class.java, DATABASE_NAME)
                        .allowMainThreadQueries().build()
                }
            }
            return instance as AppDataBase
        }
    }

    abstract fun userDao(): UserDao

}