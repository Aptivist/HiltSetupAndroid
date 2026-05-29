package com.koderbit.andrestest.domain

import com.koderbit.andrestest.data.implemtations.MySharedPreferences
import com.koderbit.andrestest.data.implemtations.SessionApi


//Name must be as long as needed
class LogoutUseCase {

    val api = SessionApi()
    val navigationService = NavigationService()
    val preferences = MySharedPreferences()

    operator fun invoke(){
        preferences.setRefreshToken("")
        api.logout()
        navigationService.goToSplash()
    }

    //No other functions public

}

class NavigationService {
    fun goToSplash(){

    }
}

class GetUserNameAndLastNameAndConvertToCamelCaseUseCase {

}

class BrewACapuccinoCoffeeInACeramicMugWithSugar {

}

class CapuccinoRepository {
    fun getInMug() {}
    fun getWithSugar() {}
}