package com.koderbit.andrestest.data.implemtations

import com.koderbit.andrestest.data.models.Animal
import com.koderbit.andrestest.data.models.LoginRequestDTO
import com.koderbit.andrestest.data.models.SessionResultDTO
import com.koderbit.andrestest.data.models.TokensDTO
import com.koderbit.andrestest.data.models.toDomain
import com.koderbit.andrestest.di.modules.ServicesModule
import com.koderbit.andrestest.domain.contracts.ILoginService
import com.koderbit.andrestest.domain.models.LoginRequest
import com.koderbit.andrestest.domain.models.LoginResponse
import javax.inject.Inject

class ApiLoginService @Inject constructor() : ILoginService {

    override suspend fun doLogin(request: LoginRequest): LoginResponse? {

        val loginRequestDto = LoginRequestDTO(
            request.username,
            request.password,
            1,
            4
        )

        val result = callApi(loginRequestDto)

        return result?.toDomain()

    }


    //emulating api
    private fun callApi(loginRequestDTO: LoginRequestDTO) : SessionResultDTO? {
        if(loginRequestDTO.username == "sergio"
            && loginRequestDTO.password == "1234"
            && loginRequestDTO.appId == 1
            && loginRequestDTO.role == 4){

            return SessionResultDTO(
                TokensDTO(sessionToken = "123", renewToken = "456"),
                mapOf<String, String>(
                    "username" to loginRequestDTO.username,
                    "password" to loginRequestDTO.username,
                    "appId" to loginRequestDTO.username,
                    "role" to loginRequestDTO.username,
                )
            )
        }

        return null
    }

}