package com.danielcano.imdbapp.domainlayer.usecases

import com.danielcano.imdbapp.datalayer.databases.User
import com.danielcano.imdbapp.datalayer.repositories.UserRepository

class UserValidationUseCaseImpl(private val userRepository: UserRepository) :
    UserValidationUseCase {

    override suspend fun registerUser(user: User) {
        userRepository.addUserToDataBase(user)
    }

    override suspend fun validateUser(userMail: String, userPass: String): Boolean {
        val user = userRepository.getUser(userMail)
        user?.let {
            if (it.password == userPass) {
                return true
            }
        }
        return false
    }
    override suspend fun userExists(userMail: String):Boolean{
        val user = userRepository.getUser(userMail)
        user?.let {
            return true
        }
        return false
    }
    override suspend fun getUserName(userMail: String):String{
        return userRepository.getUser(userMail)?.name ?: "Not given name"
    }
}