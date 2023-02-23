package com.danielcano.imdbapp.domainlayer.usecases

import com.danielcano.imdbapp.datalayer.databases.User

interface UserValidationUseCase {
    suspend fun registerUser(user: User)
    suspend fun validateUser(userMail: String, userPass: String): Boolean
    suspend fun userExists(userMail: String): Boolean
    suspend fun getUserName(userMail: String): String
}