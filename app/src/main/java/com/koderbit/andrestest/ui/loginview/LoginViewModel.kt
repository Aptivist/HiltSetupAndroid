package com.koderbit.andrestest.ui.loginview

import androidx.compose.runtime.State
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor() : ViewModel() {

    private val _username = mutableStateOf("")
    val username : State<String>
        get() = _username

    private val _password = mutableStateOf("")
    val password : State<String>
        get() = _password

    val error = derivedStateOf {
        if (_username.value.isEmpty() || _password.value.isEmpty()){
            "Username or password is empty"
        } else {
            null
        }
    }

    fun onUsernameChanged(input : String){
        //Validations
        if (input.length > 10){
            return
        }
        _username.value = input
    }

    fun onPasswordChanged(input : String){
        _password.value = input
    }

    fun onLogin(){

    }
}
