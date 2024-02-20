package com.mpcpsalesfsm.features.viewAllOrder.interf

import com.mpcpsalesfsm.app.domain.NewOrderGenderEntity
import com.mpcpsalesfsm.features.viewAllOrder.model.ProductOrder

interface ColorListOnCLick {
    fun colorListOnCLick(size_qty_list: ArrayList<ProductOrder>, adpPosition:Int)
}