package com.danielcano.imdbapp.datalayer.repositories

import android.app.Application
import com.danielcano.imdbapp.App
import com.danielcano.imdbapp.datalayer.databases.User
import com.danielcano.imdbapp.datalayer.databases.UserDatabase

class UserRepositoryImpl() : UserRepository {

    override suspend fun addUserToDataBase(user: User) {
        UserDatabase.getInstance(App.getContext()).userDao().addUser(user)
    }

    override suspend fun getUser(userMail: String): User? {
        return UserDatabase.getInstance(App.getContext()).userDao().getUserByEmail(userMail)
    }
}