package com.mpcpsalesfsm.features.nearbyuserlist.api

import com.mpcpsalesfsm.app.Pref
import com.mpcpsalesfsm.features.nearbyuserlist.model.NearbyUserResponseModel
import com.mpcpsalesfsm.features.newcollection.model.NewCollectionListResponseModel
import com.mpcpsalesfsm.features.newcollection.newcollectionlistapi.NewCollectionListApi
import io.reactivex.Observable

class NearbyUserRepo(val apiService: NearbyUserApi) {
    fun nearbyUserList(): Observable<NearbyUserResponseModel> {
        return apiService.getNearbyUserList(Pref.session_token!!, Pref.user_id!!)
    }
}