package com.mpcpsalesfsm.features.photoReg.present

import com.mpcpsalesfsm.app.domain.ProspectEntity
import com.mpcpsalesfsm.features.photoReg.model.UserListResponseModel

interface DsStatusListner {
    fun getDSInfoOnLick(obj: ProspectEntity)
}