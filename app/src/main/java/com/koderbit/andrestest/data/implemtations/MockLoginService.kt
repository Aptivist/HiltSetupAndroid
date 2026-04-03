package com.koderbit.andrestest.data.implemtations

import com.koderbit.andrestest.domain.contracts.ILoginService
import com.koderbit.andrestest.domain.models.LoginRequest
import com.koderbit.andrestest.domain.models.LoginResponse
import javax.inject.Inject

class MockErrorLoginService @Inject constructor() : ILoginService {
    override suspend fun doLogin(request: LoginRequest): LoginResponse? {
        return null
    }

}

class MockSuccessLoginService @Inject constructor(): ILoginService {
    override suspend fun doLogin(request: LoginRequest): LoginResponse? {
        return LoginResponse(
            token = "123456",
            refreshToken = "6789"
        )
    }

}