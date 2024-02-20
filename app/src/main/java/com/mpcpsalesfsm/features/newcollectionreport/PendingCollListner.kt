package com.mpcpsalesfsm.features.newcollectionreport

import com.mpcpsalesfsm.features.photoReg.model.UserListResponseModel

interface PendingCollListner {
    fun getUserInfoOnLick(obj: PendingCollData)
}