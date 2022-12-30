package com.kamrulhasan.roomdb_demo.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "user_table")
data class User(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    @NotNull val firstName: String,
    @NotNull val lastName: String,
    @NotNull val age: Int
)
