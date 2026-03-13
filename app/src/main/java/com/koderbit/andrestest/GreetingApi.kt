package com.koderbit.andrestest

import com.koderbit.andrestest.di.modules.Person
import javax.inject.Inject

class HiGreetingApi : IGreetingService {
    override fun getGreeting(): String = "Hi from Api"
}



class HiGreetingDatabase @Inject constructor(val person: Person) : IGreetingService {
    override fun getGreeting(): String = "Hi from Database to: ${person.name}"
}