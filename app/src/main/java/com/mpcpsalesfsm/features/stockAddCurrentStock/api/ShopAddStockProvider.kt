package com.mpcpsalesfsm.features.stockAddCurrentStock.api

import com.mpcpsalesfsm.features.location.shopRevisitStatus.ShopRevisitStatusApi
import com.mpcpsalesfsm.features.location.shopRevisitStatus.ShopRevisitStatusRepository

object ShopAddStockProvider {
    fun provideShopAddStockRepository(): ShopAddStockRepository {
        return ShopAddStockRepository(ShopAddStockApi.create())
    }
}