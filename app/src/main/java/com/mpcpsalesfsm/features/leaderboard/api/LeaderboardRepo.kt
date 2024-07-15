package com.mpcpsalesfsm.features.leaderboard.api

import android.content.Context
import android.net.Uri
import android.text.TextUtils
import com.fasterxml.jackson.databind.ObjectMapper
import com.mpcpsalesfsm.app.FileUtils
import com.mpcpsalesfsm.app.Pref
import com.mpcpsalesfsm.base.BaseResponse
import com.mpcpsalesfsm.features.addshop.model.AddLogReqData
import com.mpcpsalesfsm.features.addshop.model.AddShopRequestData
import com.mpcpsalesfsm.features.addshop.model.AddShopResponse
import com.mpcpsalesfsm.features.addshop.model.LogFileResponse
import com.mpcpsalesfsm.features.addshop.model.UpdateAddrReq
import com.mpcpsalesfsm.features.contacts.CallHisDtls
import com.mpcpsalesfsm.features.contacts.CompanyReqData
import com.mpcpsalesfsm.features.contacts.ContactMasterRes
import com.mpcpsalesfsm.features.contacts.SourceMasterRes
import com.mpcpsalesfsm.features.contacts.StageMasterRes
import com.mpcpsalesfsm.features.contacts.StatusMasterRes
import com.mpcpsalesfsm.features.contacts.TypeMasterRes
import com.mpcpsalesfsm.features.dashboard.presentation.DashboardActivity
import com.mpcpsalesfsm.features.login.model.WhatsappApiData
import com.mpcpsalesfsm.features.login.model.WhatsappApiFetchData
import com.google.gson.Gson
import io.reactivex.Observable
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import java.io.File

/**
 * Created by Puja on 10-10-2024.
 */
class LeaderboardRepo(val apiService: LeaderboardApi) {

    fun branchlist(session_token: String): Observable<LeaderboardBranchData> {
        return apiService.branchList(session_token)
    }
    fun ownDatalist(user_id: String,activitybased: String,branchwise: String,flag: String): Observable<LeaderboardOwnData> {
        return apiService.ownDatalist(user_id,activitybased,branchwise,flag)
    }
    fun overAllAPI(user_id: String,activitybased: String,branchwise: String,flag: String): Observable<LeaderboardOverAllData> {
        return apiService.overAllDatalist(user_id,activitybased,branchwise,flag)
    }
}