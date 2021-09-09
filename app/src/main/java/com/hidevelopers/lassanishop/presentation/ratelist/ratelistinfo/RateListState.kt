package com.hidevelopers.lassanishop.presentation.ratelist.ratelistinfo

import com.hidevelopers.lassanishop.domain.model.OwnRateList

data class RateListState<T>(
    val isLoading: Boolean = false,
    val result: T? = null,
    val error: String = ""
)
data class OwnRateListState(
    val isLoading: Boolean = false,
    val isSuccess: List<OwnRateList> = emptyList(),
    val error: String = ""
)
data class CompanyRateListState(
    val isLoading: Boolean = false,
    val isSuccess: List<OwnRateList> = emptyList(),
    val error: String = ""
)

data class SizeOwnRateListState(
    val isLoading: Boolean = false,
    val isSuccess: Long = 0L,
    val error: String = ""
)
