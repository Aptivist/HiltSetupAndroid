package com.koderbit.andrestest

import com.koderbit.andrestest.di.modules.Person
import javax.inject.Inject

class HiGreetingApi @Inject constructor() : IGreetingService {

    val api = "Api 1234"

    override fun getGreeting(): String = "Hi from $api - URL ${getURL()}"

    private fun getURL(): String {
        return "https://google.com"
    }

    fun something() = true
}



class HiGreetingDatabase @Inject constructor(val person: Person) : IGreetingService {

    override fun getGreeting(): String = "Hi from Database to: ${person.name}"
}