package com.danielcano.imdbapp.uilayer.viewmodels

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.danielcano.imdbapp.App
import com.danielcano.imdbapp.R
import com.danielcano.imdbapp.datalayer.repositories.UserRepositoryImpl
import com.danielcano.imdbapp.domainlayer.usecases.UserValidationUseCaseImpl
import kotlinx.coroutines.launch

class UserLoginViewModel : ViewModel() {
    private var userValidationUseCase: UserValidationUseCaseImpl =
        UserValidationUseCaseImpl(UserRepositoryImpl())
    private var _loginStatus = MutableLiveData<Boolean>()
    val loginStatus: LiveData<Boolean> = _loginStatus

    private var _loginData = MutableLiveData<String>()
    val loginData: LiveData<String> = _loginData


    init {
        _loginStatus.value = false
    }

    fun loginUser(userMail: String, userPass: String) {
        try {
            viewModelScope.launch {
                if (userValidationUseCase.validateUser(userMail = userMail, userPass = userPass)) {
                    _loginData.value = userValidationUseCase.getUserName(userMail)
                    _loginStatus.value = true
                } else {
                    val toast = Toast.makeText(
                        App.getContext(),
                        App.getContext().getString(R.string.not_valid_credentials),
                        Toast.LENGTH_SHORT
                    )
                    toast.show()
                }
            }
        } catch (e: Exception) {
            Log.e(App.getContext().getString(R.string.user_validation_exception), e.toString())
        }
    }
}