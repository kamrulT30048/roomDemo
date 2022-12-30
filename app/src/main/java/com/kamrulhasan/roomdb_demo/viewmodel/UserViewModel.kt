package com.kamrulhasan.roomdb_demo.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.kamrulhasan.roomdb_demo.model.User
import com.kamrulhasan.roomdb_demo.model.UserRepository
import com.kamrulhasan.roomdb_demo.model.UserRoomDB
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel(application: Application) : AndroidViewModel(application) {
    val readAllData : LiveData<List<User>>
    val repository: UserRepository

    init {
        val userDao = UserRoomDB.getDatabase(application).userDao()
        repository = UserRepository(userDao)
        readAllData = repository.readAllData
    }

    fun addUser(user: User){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addUser(user)
        }
    }

}