package com.danielcano.imdbapp.datalayer.repositories

import com.danielcano.imdbapp.datalayer.databases.User

interface UserRepository {
    suspend fun addUserToDataBase(user: User)
    suspend fun getUser(userMail: String): User?
}