package com.koderbit.andrestest.di.modules

import com.koderbit.andrestest.HiGreetingDatabase
import com.koderbit.andrestest.IGreetingService
import com.koderbit.andrestest.data.models.Animal
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent
import java.util.Random
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object GreetingModule {

    @Singleton
    @Provides
    fun providePerson() : Person = Person("Andres", 31)

    @Singleton
    @Provides
    fun provideNumber() : RandomNumber = RandomNumber(Random().nextInt(1000))

    @Provides
    @Named("Felino")
    fun provideAnimal2() : Animal = Animal("Cat")

}

data class Person(val name: String, val age: Int)
data class RandomNumber(val number: Int)
