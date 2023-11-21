package com.rufus.weatherapp2.presentation

import com.rufus.weatherapp2.domain.weather.WeatherInfo

data class WeatherState(
    val weatherInfo: WeatherInfo? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)