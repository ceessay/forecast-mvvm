package com.ceessay.android.forecast.data.network

import androidx.lifecycle.LiveData
import com.ceessay.android.forecast.data.Response.CurrentWeatherResponse

interface WeatherNetworkDataSource {

    val downloadCurrentWeather: LiveData<CurrentWeatherResponse>

    suspend fun fetchCurrentWeather(
        location: String
    )
}