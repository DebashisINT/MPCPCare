package com.mpcpsalesfsm.features.location.shopRevisitStatus

import com.mpcpsalesfsm.features.location.shopdurationapi.ShopDurationApi
import com.mpcpsalesfsm.features.location.shopdurationapi.ShopDurationRepository

object ShopRevisitStatusRepositoryProvider {
    fun provideShopRevisitStatusRepository(): ShopRevisitStatusRepository {
        return ShopRevisitStatusRepository(ShopRevisitStatusApi.create())
    }
}