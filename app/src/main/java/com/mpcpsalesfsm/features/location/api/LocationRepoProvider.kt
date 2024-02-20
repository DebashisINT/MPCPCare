package com.mpcpsalesfsm.features.location.api

import com.mpcpsalesfsm.features.location.shopdurationapi.ShopDurationApi
import com.mpcpsalesfsm.features.location.shopdurationapi.ShopDurationRepository


object LocationRepoProvider {
    fun provideLocationRepository(): LocationRepo {
        return LocationRepo(LocationApi.create())
    }
}