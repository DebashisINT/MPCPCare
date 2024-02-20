package com.mpcpsalesfsm.features.viewAllOrder.interf

import com.mpcpsalesfsm.app.domain.NewOrderProductEntity
import com.mpcpsalesfsm.app.domain.NewOrderSizeEntity

interface SizeListNewOrderOnClick {
    fun sizeListOnClick(size: NewOrderSizeEntity)
}