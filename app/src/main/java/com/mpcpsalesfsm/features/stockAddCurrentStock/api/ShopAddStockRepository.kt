package com.mpcpsalesfsm.features.stockAddCurrentStock.api

import com.mpcpsalesfsm.base.BaseResponse
import com.mpcpsalesfsm.features.location.model.ShopRevisitStatusRequest
import com.mpcpsalesfsm.features.location.shopRevisitStatus.ShopRevisitStatusApi
import com.mpcpsalesfsm.features.stockAddCurrentStock.ShopAddCurrentStockRequest
import com.mpcpsalesfsm.features.stockAddCurrentStock.model.CurrentStockGetData
import com.mpcpsalesfsm.features.stockCompetetorStock.model.CompetetorStockGetData
import io.reactivex.Observable

class ShopAddStockRepository (val apiService : ShopAddStockApi){
    fun shopAddStock(shopAddCurrentStockRequest: ShopAddCurrentStockRequest?): Observable<BaseResponse> {
        return apiService.submShopAddStock(shopAddCurrentStockRequest)
    }

    fun getCurrStockList(sessiontoken: String, user_id: String, date: String): Observable<CurrentStockGetData> {
        return apiService.getCurrStockListApi(sessiontoken, user_id, date)
    }

}