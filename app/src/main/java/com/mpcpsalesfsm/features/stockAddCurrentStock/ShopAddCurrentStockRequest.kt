package com.mpcpsalesfsm.features.stockAddCurrentStock

import com.mpcpsalesfsm.features.location.model.ShopRevisitStatusRequestData

class ShopAddCurrentStockRequest {
    var user_id: String? = null
    var session_token: String? = null
    var stock_id: String? = null
    var shop_id: String? = null
    var visited_datetime: String? = null
    var stock_product_list: List<ShopAddCurrentStockList>? = null
}