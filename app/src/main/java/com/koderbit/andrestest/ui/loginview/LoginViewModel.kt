package com.koderbit.andrestest.ui.loginview

import androidx.compose.runtime.State
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.koderbit.andrestest.domain.contracts.ILoginService
import com.koderbit.andrestest.domain.models.LoginRequest
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    val loginService : ILoginService
) : ViewModel() {

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

    private val _status = mutableStateOf<String?>(null)
    val status : State<String?>
        get() = _status

    private val _statusColor = mutableStateOf<Color>(Color.Green)
    val statusColor : State<Color>
        get() = _statusColor

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
        viewModelScope.launch {
            val request = LoginRequest(_username.value, _password.value)
            val result = loginService.doLogin(request)

            result?.let {
                _statusColor.value = Color.Green
                _status.value = "Tokens ${it.token} ${it.refreshToken}"
            } ?: run {
                _statusColor.value = Color.Red
                _status.value = "Error in login"
            }
        }
    }
}
