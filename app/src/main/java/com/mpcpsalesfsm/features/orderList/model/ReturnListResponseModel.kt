package com.mpcpsalesfsm.features.orderList.model

import com.mpcpsalesfsm.base.BaseResponse


class ReturnListResponseModel: BaseResponse() {
    var return_list: ArrayList<ReturnDataModel>? = null
}