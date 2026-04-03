package com.koderbit.andrestest.domain.contracts

import com.koderbit.andrestest.domain.models.LoginRequest
import com.koderbit.andrestest.domain.models.LoginResponse

interface ILoginService {

    suspend fun doLogin(request : LoginRequest) : LoginResponse?

}