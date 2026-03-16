package com.koderbit.andrestest.di.modules

import com.koderbit.andrestest.data.Animal
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named

@Module
@InstallIn(SingletonComponent::class)
object AnimalModule {

    @Provides
    @Named("Canino")
    fun provideAnimal(): Animal = Animal("Dog")
}


