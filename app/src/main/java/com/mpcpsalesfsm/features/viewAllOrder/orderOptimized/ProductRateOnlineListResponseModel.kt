package com.mpcpsalesfsm.features.viewAllOrder.orderOptimized

import com.mpcpsalesfsm.app.domain.ProductOnlineRateTempEntity
import com.mpcpsalesfsm.base.BaseResponse
import com.mpcpsalesfsm.features.login.model.productlistmodel.ProductRateDataModel
import java.io.Serializable

class ProductRateOnlineListResponseModel: BaseResponse(), Serializable {
    var product_rate_list: ArrayList<ProductOnlineRateTempEntity>? = null
}