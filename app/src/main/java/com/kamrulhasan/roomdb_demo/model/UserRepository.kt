package com.kamrulhasan.roomdb_demo.model

import androidx.lifecycle.LiveData

class UserRepository(private val userDao: UserDao) {

    val readAllData : LiveData<List<User>> = userDao.readAllUser()

    suspend fun addUser(user: User){
        userDao.addUser(user)
    }
}