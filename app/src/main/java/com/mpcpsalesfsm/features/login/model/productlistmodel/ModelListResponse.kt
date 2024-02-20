package com.mpcpsalesfsm.features.login.model.productlistmodel

import com.mpcpsalesfsm.app.domain.ModelEntity
import com.mpcpsalesfsm.app.domain.ProductListEntity
import com.mpcpsalesfsm.base.BaseResponse

class ModelListResponse: BaseResponse() {
    var model_list: ArrayList<ModelEntity>? = null
}