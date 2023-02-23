package com.danielcano.imdbapp.datalayer.databases

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UserDao {
    @Query("SELECT * FROM user WHERE email LIKE :mail")
    suspend fun getUserByEmail(mail:String):User

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addUser(user:User)
}
