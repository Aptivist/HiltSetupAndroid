package com.koderbit.andrestest.di.modules

import com.koderbit.andrestest.HiGreetingDatabase
import com.koderbit.andrestest.IGreetingService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import java.util.Random

@Module
@InstallIn(SingletonComponent::class)
object GreetingModule {

    @Provides
    fun providePerson() : Person = Person("Andres", 31)

    @Provides
    fun provideNumber() : RandomNumber = RandomNumber(Random().nextInt(1000))

}

data class Person(val name: String, val age: Int)
data class RandomNumber(val number: Int)
