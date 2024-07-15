package com.mpcpsalesfsm.features.login.model.opportunitymodel

import com.mpcpsalesfsm.app.domain.OpportunityStatusEntity
import com.mpcpsalesfsm.app.domain.ProductListEntity
import com.mpcpsalesfsm.base.BaseResponse

/**
 * Created by Puja on 30.05.2024
 */
class OpportunityStatusListResponseModel : BaseResponse() {
    var status_list: ArrayList<OpportunityStatusEntity>? = null
}