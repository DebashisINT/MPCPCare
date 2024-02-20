package com.mpcpsalesfsm.features.newcollection.model

import com.mpcpsalesfsm.app.domain.CollectionDetailsEntity
import com.mpcpsalesfsm.base.BaseResponse
import com.mpcpsalesfsm.features.shopdetail.presentation.model.collectionlist.CollectionListDataModel

/**
 * Created by Saikat on 15-02-2019.
 */
class NewCollectionListResponseModel : BaseResponse() {
    //var collection_list: ArrayList<CollectionListDataModel>? = null
    var collection_list: ArrayList<CollectionDetailsEntity>? = null
}