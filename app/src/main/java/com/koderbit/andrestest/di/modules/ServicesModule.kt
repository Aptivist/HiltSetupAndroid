package com.koderbit.andrestest.di.modules

import com.koderbit.andrestest.data.implemtations.ApiLoginService
import com.koderbit.andrestest.data.implemtations.MockErrorLoginService
import com.koderbit.andrestest.data.implemtations.MockSuccessLoginService
import com.koderbit.andrestest.data.models.Animal
import com.koderbit.andrestest.domain.contracts.ILoginService
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class ServicesModule {

    @Singleton
    @Binds
    abstract fun providesLoginService(
        apiLoginSeriviceImplementation : ApiLoginService
    ) : ILoginService

}

/*
@Module
@InstallIn(SingletonComponent::class)
object ServicesModule {

    @Singleton
    @Provides
    fun provideLoginService(animal: Animal) : ILoginService {
        return ApiLoginService(animal, "Sergio")
    }
}

*/
