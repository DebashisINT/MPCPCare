package com.mpcpsalesfsm.features.weather.api

import com.mpcpsalesfsm.base.BaseResponse
import com.mpcpsalesfsm.features.task.api.TaskApi
import com.mpcpsalesfsm.features.task.model.AddTaskInputModel
import com.mpcpsalesfsm.features.weather.model.ForeCastAPIResponse
import com.mpcpsalesfsm.features.weather.model.WeatherAPIResponse
import io.reactivex.Observable

class WeatherRepo(val apiService: WeatherApi) {
    fun getCurrentWeather(zipCode: String): Observable<WeatherAPIResponse> {
        return apiService.getTodayWeather(zipCode)
    }

    fun getWeatherForecast(zipCode: String): Observable<ForeCastAPIResponse> {
        return apiService.getForecast(zipCode)
    }
}