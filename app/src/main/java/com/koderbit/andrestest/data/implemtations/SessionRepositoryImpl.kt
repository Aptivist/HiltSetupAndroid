package com.koderbit.andrestest.data.implemtations

import com.koderbit.andrestest.domain.contracts.ISessionRepository
import com.koderbit.andrestest.domain.models.LoginResponse

class SessionRepositoryImpl : ISessionRepository {
   
    val database = MyDatabase()
    val sharedPrefs = MySharedPreferences()
    val api = SessionApi()
    
    override fun refreshSession(): Boolean {

        if(!database.isSessionActive()) return false
        
        val token = sharedPrefs.getRefreshToken()
        val result = api.refreshSession(token)
        result?.let {
            sharedPrefs.setRefreshToken(it)
            return true
        }
        return false
    }

    override fun doLogin(username: String, password: String) : LoginResponse {
        //all logic to login
        //then
        //convert/map result to our domain model
        return LoginResponse(sharedPrefs.getRefreshToken(), sharedPrefs.getRefreshToken())
    }

    override fun logout() {
        TODO("Not yet implemented")
    }


}


class MyDatabase {
    
    private var activeSession = false
    
    fun isSessionActive() : Boolean = activeSession
    
    fun refreshSession(isActive : Boolean) {
        activeSession = isActive
    }
}

class MySharedPreferences {
    
    private var refreshToken = "ABC123454"
    
    fun getRefreshToken() = refreshToken
    
    fun setRefreshToken(newToken :String){
        refreshToken = newToken
    }
}

class SessionApi {
    fun refreshSession(refreshToken : String) : String? = if (refreshToken.isNotEmpty()) "ERERGERHRHHRe" else null
    fun logout() {

    }
}