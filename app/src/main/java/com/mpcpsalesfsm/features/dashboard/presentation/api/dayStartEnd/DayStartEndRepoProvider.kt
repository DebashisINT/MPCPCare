package com.mpcpsalesfsm.features.dashboard.presentation.api.dayStartEnd

import com.mpcpsalesfsm.features.stockCompetetorStock.api.AddCompStockApi
import com.mpcpsalesfsm.features.stockCompetetorStock.api.AddCompStockRepository

object DayStartEndRepoProvider {
    fun dayStartRepositiry(): DayStartEndRepository {
        return DayStartEndRepository(DayStartEndApi.create())
    }

}