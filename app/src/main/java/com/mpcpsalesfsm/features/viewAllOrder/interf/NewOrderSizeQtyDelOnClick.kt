package com.mpcpsalesfsm.features.viewAllOrder.interf

import com.mpcpsalesfsm.app.domain.NewOrderGenderEntity
import com.mpcpsalesfsm.features.viewAllOrder.model.ProductOrder
import java.text.FieldPosition

interface NewOrderSizeQtyDelOnClick {
    fun sizeQtySelListOnClick(product_size_qty: ArrayList<ProductOrder>)
    fun sizeQtyListOnClick(product_size_qty: ProductOrder,position: Int)
}