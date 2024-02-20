package com.mpcpsalesfsm.features.viewAllOrder.interf

import com.mpcpsalesfsm.app.domain.NewOrderColorEntity
import com.mpcpsalesfsm.app.domain.NewOrderProductEntity

interface ColorListNewOrderOnClick {
    fun productListOnClick(color: NewOrderColorEntity)
}