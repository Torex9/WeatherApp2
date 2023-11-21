package com.rufus.weatherapp2.data.repository

import com.rufus.weatherapp2.data.mappers.toWeatherInfo
import com.rufus.weatherapp2.data.remote.WeatherApi
import com.rufus.weatherapp2.domain.repository.WeatherRepository
import com.rufus.weatherapp2.domain.util.Resource
import com.rufus.weatherapp2.domain.weather.WeatherInfo
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val api: WeatherApi
): WeatherRepository {

    override suspend fun getWeatherData(lat: Double, long: Double): Resource<WeatherInfo> {
        return try {
            Resource.Success(
                data = api.getWeatherData(
                    lat = lat,
                    long = long
                ).toWeatherInfo()
            )
        } catch(e: Exception) {
            e.printStackTrace()
            Resource.Error(e.message ?: "An unknown error occurred.")
        }
    }
}