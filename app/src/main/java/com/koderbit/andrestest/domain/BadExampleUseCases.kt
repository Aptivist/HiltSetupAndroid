package com.koderbit.andrestest.domain

//Data
//Retrofit
interface WeatherApi {
    fun getWeather (city: String) : String
}

//Domain

data class Weather(val city: String, val weather: String)

interface IWeatherRepository {
    fun getWeather(city: String) : Weather
}

class WeatherRepoImpl(val api: WeatherApi): IWeatherRepository {

    override fun getWeather(city: String): Weather {
        val result = api.getWeather(city)
        return Weather(city, result)
    }

}

//This is bad
class GetWeatherUseCase(val weatherRepo: IWeatherRepository) {
    operator fun invoke(city: String) : Weather {
        return weatherRepo.getWeather(city)
    }
}

//other name
class GetWeatherAndConvertToUserSelectedUnitOfMeasureUseCase(val weatherRepo: IWeatherRepository) {
    operator fun invoke(city: String) : Weather {
        val result = weatherRepo.getWeather(city)
        //process data...
        return result
    }
}