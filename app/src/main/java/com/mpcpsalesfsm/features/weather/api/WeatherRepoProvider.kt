package com.mpcpsalesfsm.features.weather.api

import com.mpcpsalesfsm.features.task.api.TaskApi
import com.mpcpsalesfsm.features.task.api.TaskRepo

object WeatherRepoProvider {
    fun weatherRepoProvider(): WeatherRepo {
        return WeatherRepo(WeatherApi.create())
    }
}