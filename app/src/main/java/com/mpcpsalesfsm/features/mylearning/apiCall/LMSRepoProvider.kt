package com.mpcpsalesfsm.features.mylearning.apiCall

import com.mpcpsalesfsm.features.login.api.opportunity.OpportunityListApi
import com.mpcpsalesfsm.features.login.api.opportunity.OpportunityListRepo

object LMSRepoProvider {
    fun getTopicList(): LMSRepo {
        return LMSRepo(LMSApi.create())
    }
}