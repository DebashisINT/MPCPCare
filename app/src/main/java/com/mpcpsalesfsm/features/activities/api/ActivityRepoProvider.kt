package com.mpcpsalesfsm.features.activities.api

import com.mpcpsalesfsm.features.member.api.TeamApi
import com.mpcpsalesfsm.features.member.api.TeamRepo

object ActivityRepoProvider {
    fun activityRepoProvider(): ActivityRepo {
        return ActivityRepo(ActivityApi.create())
    }

    fun activityImageRepoProvider(): ActivityRepo {
        return ActivityRepo(ActivityApi.createImage())
    }
}