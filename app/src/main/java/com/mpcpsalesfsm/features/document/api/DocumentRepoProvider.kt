package com.mpcpsalesfsm.features.document.api

import com.mpcpsalesfsm.features.dymanicSection.api.DynamicApi
import com.mpcpsalesfsm.features.dymanicSection.api.DynamicRepo

object DocumentRepoProvider {
    fun documentRepoProvider(): DocumentRepo {
        return DocumentRepo(DocumentApi.create())
    }

    fun documentRepoProviderMultipart(): DocumentRepo {
        return DocumentRepo(DocumentApi.createImage())
    }
}