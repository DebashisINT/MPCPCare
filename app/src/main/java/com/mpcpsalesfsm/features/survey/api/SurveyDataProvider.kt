package com.mpcpsalesfsm.features.survey.api

import com.mpcpsalesfsm.features.photoReg.api.GetUserListPhotoRegApi
import com.mpcpsalesfsm.features.photoReg.api.GetUserListPhotoRegRepository

object SurveyDataProvider{

    fun provideSurveyQ(): SurveyDataRepository {
        return SurveyDataRepository(SurveyDataApi.create())
    }

    fun provideSurveyQMultiP(): SurveyDataRepository {
        return SurveyDataRepository(SurveyDataApi.createImage())
    }
}