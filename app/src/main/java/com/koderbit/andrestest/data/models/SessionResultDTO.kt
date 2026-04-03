package com.koderbit.andrestest.data.models

import com.koderbit.andrestest.domain.models.LoginResponse

data class SessionResultDTO(val tokens : TokensDTO, val metadata: Map<String, String>)
data class TokensDTO(val sessionToken: String, val renewToken: String)


fun SessionResultDTO.toDomain() : LoginResponse {
    return LoginResponse(
        token = this.tokens.sessionToken,
        refreshToken = this.tokens.renewToken
    )
}