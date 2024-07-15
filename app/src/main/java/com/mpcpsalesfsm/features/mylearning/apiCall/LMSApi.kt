package com.mpcpsalesfsm.features.mylearning.apiCall

import com.mpcpsalesfsm.app.NetworkConstant
import com.mpcpsalesfsm.features.login.api.opportunity.OpportunityListApi
import com.mpcpsalesfsm.features.login.model.opportunitymodel.OpportunityStatusListResponseModel
import com.mpcpsalesfsm.features.mylearning.TopicListResponse
import com.mpcpsalesfsm.features.mylearning.VideoTopicWiseResponse
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface LMSApi {

    @FormUrlEncoded
    @POST("LMSInfoDetails/TopicLists")
    fun getTopics(@Field("user_id") user_id: String): Observable<TopicListResponse>

    @FormUrlEncoded
    @POST("LMSInfoDetails/TopicWiseLists")
    fun getTopicswiseVideoApi(@Field("topic_id") topic_id: String): Observable<VideoTopicWiseResponse>

    companion object Factory {
        fun create(): LMSApi {
            val retrofit = Retrofit.Builder()
                .client(NetworkConstant.setTimeOut())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(NetworkConstant.BASE_URL)
                .build()

            return retrofit.create(LMSApi::class.java)
        }
    }
}