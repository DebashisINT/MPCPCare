package com.mpcpsalesfsm.features.viewAllOrder.interf

import com.mpcpsalesfsm.app.domain.NewOrderGenderEntity
import com.mpcpsalesfsm.app.domain.NewOrderProductEntity

interface ProductListNewOrderOnClick {
    fun productListOnClick(product: NewOrderProductEntity)
}