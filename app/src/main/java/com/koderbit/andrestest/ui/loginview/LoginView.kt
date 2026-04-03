package com.koderbit.andrestest.ui.loginview

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel

@Composable
fun LoginView(vm : LoginViewModel = hiltViewModel()) {

    val username = remember { vm.username }
    val password = remember { vm.password }
    val error = remember { vm.error }
    val status = remember { vm.status }
    val statusColor = remember { vm.statusColor }


    LoginViewContent(modifier = Modifier.fillMaxSize(),
        username = username.value,
        password = password.value,
        error = error.value,
        status = status.value,
        statusColor = statusColor.value,
        onUsernameChanged = vm::onUsernameChanged,
        onPasswordChanged = vm::onPasswordChanged,
        onLoginClicked = vm::onLogin)
}

@Composable
private fun LoginViewContent(modifier: Modifier = Modifier,
                             username : String,
                             password : String,
                             error : String?,
                             status : String?,
                             statusColor : Color,
                             onUsernameChanged: (String) -> Unit,
                             onPasswordChanged: (String) -> Unit,
                             onLoginClicked: () -> Unit) {

    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterVertically)) {

        TextField(value = username, onValueChange = onUsernameChanged)
        TextField(value = password, onValueChange = { onPasswordChanged(it) })

        Button(onClick = onLoginClicked, enabled = error == null) {
            Text(text = "Login")
        }

       /* error?.let {
            Text(it, color = MaterialTheme.colorScheme.error)
        } */

        if(error != null) {
            Text(error, color = MaterialTheme.colorScheme.error)
        }

        status?.let {
            Text(it, color = statusColor)
        }


    }
}

@Preview
@Composable
fun LoginViewPreview() {
    LoginViewContent(modifier = Modifier.fillMaxSize(),
        username = "username",
        password = "password",
        error = null,
        status = "Hi",
        statusColor = Color.Black,
        onUsernameChanged = {},
        onPasswordChanged = {},
        onLoginClicked = {})
}
