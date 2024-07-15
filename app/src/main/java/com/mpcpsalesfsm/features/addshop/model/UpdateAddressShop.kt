package com.mpcpsalesfsm.features.addshop.model

import com.mpcpsalesfsm.app.domain.AddShopDBModelEntity
import com.mpcpsalesfsm.app.domain.CallHisEntity
import com.mpcpsalesfsm.base.BaseResponse

data class UpdateAddrReq  (var user_id:String="",var shop_list:ArrayList<UpdateAddressShop> = ArrayList())

data class UpdateAddressShop(var shop_id:String="",var shop_updated_lat:String="",var shop_updated_long:String="",var shop_updated_address:String="")