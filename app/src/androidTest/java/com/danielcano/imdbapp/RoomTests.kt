package com.danielcano.imdbapp

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.danielcano.imdbapp.datalayer.databases.User
import com.danielcano.imdbapp.datalayer.databases.UserDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
class RoomTests {
    private lateinit var userDatabase: UserDatabase

    @Before
    fun setUpDatabase() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        userDatabase = Room.inMemoryDatabaseBuilder(context, UserDatabase::class.java).build()
    }

    @Test
    fun createAndConsultUser_user_success() {
        //Arrange
        val user = User(name = "Daniel", email = "daniel.cano@gmail.com", password = "1234")
        runTest {
            //Act
            userDatabase.userDao().addUser(user)
            val usuario = userDatabase.userDao().getUserByEmail("daniel.cano@gmail.com")
            //Assert
            assert(usuario.name == "Daniel")
        }
    }

    @Test
    fun checkUserPassword_user_success() {
        //Arrange
        val user = User(name = "Carlos", email = "carlos@gmail.com", password = "34512")
        CoroutineScope(Dispatchers.IO).launch {
            //Act
            userDatabase.userDao().addUser(user)
            val usuario = userDatabase.userDao().getUserByEmail("carlos@gmail.com")
            //Assert
            assert(usuario.password == "34512")
        }
    }
}