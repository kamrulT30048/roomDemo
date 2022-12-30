package com.kamrulhasan.roomdb_demo.model

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query

@Dao
interface UserDao {

    @Insert(onConflict = REPLACE)
    suspend fun addUser(user: User)

    @Query("SELECT * FROM user_table ORDER BY age ASC")
    fun readAllUser(): LiveData<List<User>>

}