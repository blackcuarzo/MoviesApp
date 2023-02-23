package com.danielcano.imdbapp.uilayer.viewmodels

import android.util.Log
import android.util.Patterns
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.danielcano.imdbapp.App
import com.danielcano.imdbapp.R
import com.danielcano.imdbapp.datalayer.databases.User
import com.danielcano.imdbapp.datalayer.repositories.UserRepositoryImpl
import com.danielcano.imdbapp.domainlayer.usecases.UserValidationUseCaseImpl
import kotlinx.coroutines.launch

class UserRegistrationViewModel : ViewModel() {
    private var userValidationUseCase: UserValidationUseCaseImpl =
        UserValidationUseCaseImpl(UserRepositoryImpl())
    private var _registrationStatus = MutableLiveData<Boolean>()
    val registrationStatus: LiveData<Boolean> = _registrationStatus

    init {
        _registrationStatus.value = false
    }

    fun registerUser(name: String, email: String, pass: String) {
        when {
            name.isEmpty() -> showErrorMessage(App.getContext().getString(R.string.empty_name_error))
            email.isEmpty() -> showErrorMessage(App.getContext().getString(R.string.empty_mail_error))
            pass.isEmpty() -> showErrorMessage(App.getContext().getString(R.string.empty_password_error))
            pass.length < 8 -> showErrorMessage(App.getContext().getString(R.string.short_password_error))
            !Patterns.EMAIL_ADDRESS.matcher(email).matches() -> showErrorMessage(App.getContext().getString(R.string.not_valid_email_error))
            else -> {
                viewModelScope.launch {
                    try {
                        if (userValidationUseCase.userExists(email)) {
                            showErrorMessage(App.getContext().getString(R.string.preexistent_user_error))
                        } else {
                            userValidationUseCase.registerUser(
                                User(
                                    name = name,
                                    email = email,
                                    password = pass
                                )
                            )
                            if (userValidationUseCase.validateUser(
                                    userMail = email,
                                    userPass = pass
                                )
                            ) {
                                _registrationStatus.value = true
                            } else {
                                showErrorMessage(App.getContext().getString(R.string.registering_problem_error))
                            }
                        }
                    } catch (e: Exception) {
                        Log.e(App.getContext().getString(R.string.user_validation_exception), e.toString())
                    }
                }
            }
        }
    }

    private fun showErrorMessage(message: String) {
        val toast = Toast.makeText(
            App.getContext(),
            message,
            Toast.LENGTH_SHORT
        )
        toast.show()
    }
}