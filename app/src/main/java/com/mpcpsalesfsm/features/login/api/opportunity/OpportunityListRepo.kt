package com.mpcpsalesfsm.features.login.api.opportunity

import com.mpcpsalesfsm.app.Pref
import com.mpcpsalesfsm.app.utils.AppUtils
import com.mpcpsalesfsm.base.BaseResponse
import com.mpcpsalesfsm.features.login.model.opportunitymodel.OpportunityStatusListResponseModel
import com.mpcpsalesfsm.features.login.model.productlistmodel.ProductListResponseModel
import com.mpcpsalesfsm.features.orderITC.SyncDeleteOppt
import com.mpcpsalesfsm.features.orderITC.SyncEditOppt
import com.mpcpsalesfsm.features.orderITC.SyncOppt
import com.mpcpsalesfsm.features.orderList.model.OpportunityListResponseModel
import io.reactivex.Observable
import timber.log.Timber

/**
 * Created by Saikat on 20-11-2018.
 */
class OpportunityListRepo(val apiService: OpportunityListApi) {
    fun getOpportunityStatus(session_token: String): Observable<OpportunityStatusListResponseModel> {
        return apiService.getOpportunityStatusList(session_token)
    }

    fun saveOpportunity(syncOppt: SyncOppt): Observable<BaseResponse> {
        return apiService.saveOpportunity(syncOppt)
    }

    fun editOpportunity(syncEditOppt: SyncEditOppt): Observable<BaseResponse> {
        return apiService.editOpportunity(syncEditOppt)
    }
    fun deleteOpportunity(syncDeleteOppt: SyncDeleteOppt): Observable<BaseResponse> {
        return apiService.deleteOpportunity(syncDeleteOppt)
    }
    fun getOpportunityL(user_id: String): Observable<OpportunityListResponseModel> {
        return apiService.getOpportunityL(user_id)
    }
}