package com.mpcpsalesfsm.features.location.shopRevisitStatus

import com.mpcpsalesfsm.base.BaseResponse
import com.mpcpsalesfsm.features.location.model.ShopDurationRequest
import com.mpcpsalesfsm.features.location.model.ShopRevisitStatusRequest
import io.reactivex.Observable

class ShopRevisitStatusRepository(val apiService : ShopRevisitStatusApi) {
    fun shopRevisitStatus(shopRevisitStatus: ShopRevisitStatusRequest?): Observable<BaseResponse> {
        return apiService.submShopRevisitStatus(shopRevisitStatus)
    }
}