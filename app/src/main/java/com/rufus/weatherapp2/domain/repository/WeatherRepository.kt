package com.rufus.weatherapp2.domain.repository

import com.rufus.weatherapp2.domain.util.Resource
import com.rufus.weatherapp2.domain.weather.WeatherInfo

interface WeatherRepository {
    suspend fun getWeatherData(lat: Double, long: Double): Resource<WeatherInfo>
}