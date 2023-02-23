package com.danielcano.imdbapp

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.danielcano.imdbapp.datalayer.databases.User
import com.danielcano.imdbapp.domainlayer.usecases.UserValidationUseCaseImpl
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Test
import org.junit.runner.RunWith


@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
class UserValidationCaseFakeTests {

    @Test
    fun userRepository_getUser_userMail_success() {
        //Arrange
        val userRepositoryFake = UserRepositoryFake()
        val user = User(email = "carlos.gmail.com", name = "carlos", password = "1234")
        //Act
        runTest{
            userRepositoryFake.addUserToDataBase(user)
        //Assert
            assert(userRepositoryFake.getUser(user.email)!!.email == user.email)
        }
    }

    @Test
    fun userValidationUseCase_registerUser_success() {
        //Arrange
        val userValidationUseCase = UserValidationUseCaseImpl(UserRepositoryFake())
        val user1 = User(name = "Carlos", email = "carlos@gmail.com", password = "12345")
        val user2 = User(name = "Juan", email = "juan@gmail.com", password = "123")
        //Act
        runTest {
            userValidationUseCase.registerUser(user1)
            userValidationUseCase.registerUser(user2)
        //Assert
            assert(user2.name == userValidationUseCase.getUserName(user2.email))
        }
    }

    @Test
    fun userValidationUseCase_validateUser_userMailAndUserPass_success() {
        //Arrange
        val userValidationUseCase = UserValidationUseCaseImpl(UserRepositoryFake())
        val user1 = User(name = "Carlos", email = "carlos@gmail.com", password = "12345")
        val user2 = User(name = "Juan", email = "juan@gmail.com", password = "123")
        //Act
        runTest {
            userValidationUseCase.registerUser(user1)
            userValidationUseCase.registerUser(user2)
        //Assert
            assert(
                userValidationUseCase.validateUser(
                    userMail = "carlos@gmail.com",
                    userPass = "12345"
                )
            )
        }
    }

    @Test
    fun userValidationUseCase_validateUser_fail() {
        //Arrange
        val userValidationUseCase = UserValidationUseCaseImpl(UserRepositoryFake())
        val user1 = User(name = "Carlos", email = "carlos@gmail.com", password = "12345")
        val user2 = User(name = "Juan", email = "juan@gmail.com", password = "123")
        //Act
        runTest {
            userValidationUseCase.registerUser(user1)
            userValidationUseCase.registerUser(user2)
            //Assert
            assert(!userValidationUseCase.validateUser("juan@gmail.com", "12345"))
        }

    }
}