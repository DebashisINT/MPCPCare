package com.mpcpsalesfsm.features.lead.api

import com.mpcpsalesfsm.features.NewQuotation.api.GetQuotListRegRepository
import com.mpcpsalesfsm.features.NewQuotation.api.GetQutoListApi


object GetLeadRegProvider {
    fun provideList(): GetLeadListRegRepository {
        return GetLeadListRegRepository(GetLeadListApi.create())
    }
}