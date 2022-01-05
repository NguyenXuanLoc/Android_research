package com.example.android_research.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import io.reactivex.Single

@Dao
interface UserDao {

    @Query("SELECT * FROM user")
    fun getAll(): Single<List<UserModel>>


    @Insert
    fun insert(user: UserModel)

    @Delete
    fun delete(user: UserModel)
}