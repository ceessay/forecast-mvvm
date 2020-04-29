package com.ceessay.android.forecast.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ceessay.android.forecast.data.Response.CURRENT_WEATHER_ID
import com.ceessay.android.forecast.data.Response.CurrentWeatherEntry




@Dao
interface CurrentWeatherDao {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upsert(weatherEntry: CurrentWeatherEntry)

    @Query("Select * from current_weather where id = $CURRENT_WEATHER_ID")
    fun getCurrentWeather() : LiveData<CurrentWeatherEntry>
}