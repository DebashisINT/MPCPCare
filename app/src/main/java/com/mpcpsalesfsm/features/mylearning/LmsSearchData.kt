package com.mpcpsalesfsm.features.mylearning

data class LmsSearchData(val searchid: String,val courseName: String, var isSelected: Boolean = false/*, val courseImg: Int*/)
data class HeaderItem(val headerText: String, val valueItems: List<ValueItem>)
data class ValueItem(val valueHeader: String, val valueText: String, val imageResId: Int)
