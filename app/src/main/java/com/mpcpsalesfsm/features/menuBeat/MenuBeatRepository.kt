package com.mpcpsalesfsm.features.menuBeat

import android.content.Context
import android.net.Uri
import android.text.TextUtils
import android.util.Log
import com.fasterxml.jackson.databind.ObjectMapper
import com.mpcpsalesfsm.app.FileUtils
import com.mpcpsalesfsm.app.Pref
import com.mpcpsalesfsm.base.BaseResponse
import com.mpcpsalesfsm.features.addshop.model.*
import com.mpcpsalesfsm.features.addshop.model.assigntopplist.AddShopUploadImg
import com.mpcpsalesfsm.features.addshop.model.assigntopplist.AddshopImageMultiReqbody1
import com.mpcpsalesfsm.features.addshop.presentation.ShopListSubmitResponse
import com.mpcpsalesfsm.features.addshop.presentation.multiContactRequestData
import com.mpcpsalesfsm.features.beatCustom.BeatGetStatusModel
import com.mpcpsalesfsm.features.dashboard.presentation.DashboardActivity
import com.google.gson.Gson
import io.reactivex.Observable
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import java.io.File

/**
 * Created by saheli on 16-12-2023.
 */
class MenuBeatRepository(val apiService: MenuBeatApi) {

    fun currentTabMenubeat(sessiontoken: String, user_id: String, beat_id: String): Observable<MenuBeatResponse> {
        return apiService.getCurrentTabData(user_id,sessiontoken,beat_id)
    }
    fun hirerchyTabMenubeat(sessiontoken: String, user_id: String): Observable<MenuBeatAreaRouteResponse> {
        return apiService.getHirerchyTabData(user_id,sessiontoken)
    }

}