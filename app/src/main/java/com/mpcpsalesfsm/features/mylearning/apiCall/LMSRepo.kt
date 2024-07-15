package com.mpcpsalesfsm.features.mylearning.apiCall

import com.mpcpsalesfsm.features.login.api.opportunity.OpportunityListApi
import com.mpcpsalesfsm.features.login.model.opportunitymodel.OpportunityStatusListResponseModel
import com.mpcpsalesfsm.features.mylearning.TopicListResponse
import com.mpcpsalesfsm.features.mylearning.VideoPlayLMS
import com.mpcpsalesfsm.features.mylearning.VideoTopicWiseResponse
import io.reactivex.Observable

class LMSRepo(val apiService: LMSApi) {

    fun getTopics(user_id: String): Observable<TopicListResponse> {
        return apiService.getTopics(user_id)
    }

    fun getTopicsWiseVideo(topic_id: String): Observable<VideoTopicWiseResponse> {
        return apiService.getTopicswiseVideoApi(topic_id)
    }
}