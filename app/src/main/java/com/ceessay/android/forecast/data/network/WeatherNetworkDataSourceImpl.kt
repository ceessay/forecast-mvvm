package com.ceessay.android.forecast.data.network

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ceessay.android.forecast.data.Response.CurrentWeatherResponse
import com.ceessay.android.forecast.internal.NoConnectivityException

class WeatherNetworkDataSourceImpl (
    private val weatherApiService: WeatherApiService
) : WeatherNetworkDataSource {

    private val _downloadCurrentWeather = MutableLiveData<CurrentWeatherResponse>()
    override val downloadCurrentWeather: LiveData<CurrentWeatherResponse>
        get() = _downloadCurrentWeather

    override suspend fun fetchCurrentWeather(location: String) {
        try {
            val fetchedCurrentWeather = weatherApiService
                .getCurrentWeather(location)
                .await()

            _downloadCurrentWeather.postValue(fetchedCurrentWeather)
        }
        catch (e: NoConnectivityException) {
            Log.d("Connectivity", "No internet connection.", e)
        }

    }
}