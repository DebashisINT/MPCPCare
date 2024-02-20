package com.mpcpsalesfsm.features.viewAllOrder.interf

import com.mpcpsalesfsm.features.viewAllOrder.model.ProductOrder

interface EmptyProductOnClick {
    fun emptyProductOnCLick(emptyFound:Boolean)
    fun delProductOnCLick(isDel:Boolean)
}