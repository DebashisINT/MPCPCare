package com.mpcpsalesfsm.features.stockCompetetorStock.api

import com.mpcpsalesfsm.base.BaseResponse
import com.mpcpsalesfsm.features.orderList.model.NewOrderListResponseModel
import com.mpcpsalesfsm.features.stockCompetetorStock.ShopAddCompetetorStockRequest
import com.mpcpsalesfsm.features.stockCompetetorStock.model.CompetetorStockGetData
import io.reactivex.Observable

class AddCompStockRepository(val apiService:AddCompStockApi){

    fun addCompStock(shopAddCompetetorStockRequest: ShopAddCompetetorStockRequest): Observable<BaseResponse> {
        return apiService.submShopCompStock(shopAddCompetetorStockRequest)
    }

    fun getCompStockList(sessiontoken: String, user_id: String, date: String): Observable<CompetetorStockGetData> {
        return apiService.getCompStockList(sessiontoken, user_id, date)
    }
}