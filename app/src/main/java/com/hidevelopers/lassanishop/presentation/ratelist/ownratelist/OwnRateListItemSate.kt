package com.hidevelopers.lassanishop.presentation.ratelist.ownratelist

import com.hidevelopers.lassanishop.domain.model.OwnRateListById

data class OwnRateListItemSate(
    val isLoading: Boolean = false,
    val error: String = "",
    val isSuccess: List<OwnRateListById> = emptyList()
)
