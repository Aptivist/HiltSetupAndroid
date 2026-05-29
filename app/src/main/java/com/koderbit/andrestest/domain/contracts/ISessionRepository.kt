package com.koderbit.andrestest.domain.contracts

import com.koderbit.andrestest.domain.models.LoginResponse

interface ISessionRepository {
    fun refreshSession() : Boolean
    fun doLogin(username: String, password: String) : LoginResponse
    fun logout()
}