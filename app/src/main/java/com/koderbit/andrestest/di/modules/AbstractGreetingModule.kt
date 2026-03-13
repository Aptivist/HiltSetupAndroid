package com.koderbit.andrestest.di.modules

import com.koderbit.andrestest.HiGreetingDatabase
import com.koderbit.andrestest.IGreetingService
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class AbstractGreetingModule {

    @Binds
    abstract fun provideGreeting(greetingImplementation: HiGreetingDatabase) : IGreetingService

}