package com.mpcpsalesfsm.features.viewAllOrder.model

import com.mpcpsalesfsm.app.domain.NewOrderColorEntity
import com.mpcpsalesfsm.app.domain.NewOrderGenderEntity
import com.mpcpsalesfsm.app.domain.NewOrderProductEntity
import com.mpcpsalesfsm.app.domain.NewOrderSizeEntity
import com.mpcpsalesfsm.features.stockCompetetorStock.model.CompetetorStockGetDataDtls

class NewOrderDataModel {
    var status:String ? = null
    var message:String ? = null
    var Gender_list :ArrayList<NewOrderGenderEntity>? = null
    var Product_list :ArrayList<NewOrderProductEntity>? = null
    var Color_list :ArrayList<NewOrderColorEntity>? = null
    var size_list :ArrayList<NewOrderSizeEntity>? = null
}

