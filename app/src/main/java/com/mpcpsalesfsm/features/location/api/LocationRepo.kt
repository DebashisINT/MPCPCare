package com.mpcpsalesfsm.features.location.api

import com.mpcpsalesfsm.app.Pref
import com.mpcpsalesfsm.base.BaseResponse
import com.mpcpsalesfsm.features.location.model.AppInfoInputModel
import com.mpcpsalesfsm.features.location.model.AppInfoResponseModel
import com.mpcpsalesfsm.features.location.model.GpsNetInputModel
import com.mpcpsalesfsm.features.location.model.ShopDurationRequest
import com.mpcpsalesfsm.features.location.shopdurationapi.ShopDurationApi
import io.reactivex.Observable

/**
 * Created by Saikat on 17-Aug-20.
 */
class LocationRepo(val apiService: LocationApi) {
    fun appInfo(appInfo: AppInfoInputModel?): Observable<BaseResponse> {
        return apiService.submitAppInfo(appInfo)
    }

    fun getAppInfo(): Observable<AppInfoResponseModel> {
        return apiService.getAppInfo(Pref.session_token!!, Pref.user_id!!)
    }

    fun gpsNetInfo(appInfo: GpsNetInputModel?): Observable<BaseResponse> {
        return apiService.submitGpsNetInfo(appInfo)
    }
}