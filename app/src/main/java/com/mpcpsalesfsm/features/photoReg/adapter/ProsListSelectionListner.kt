package com.mpcpsalesfsm.features.photoReg.adapter

import com.mpcpsalesfsm.features.photoReg.model.ProsCustom
import com.mpcpsalesfsm.features.photoReg.model.UserListResponseModel

interface ProsListSelectionListner {
    fun getInfo(obj: ProsCustom)
}