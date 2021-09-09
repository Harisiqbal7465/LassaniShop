package com.hidevelopers.lassanishop.domain.model

data class OwnRateListById(
    val ownRateListId: Int,
    val ownRateListName: String,
    val ownRateListItemName: String,
    val weightPrice: List<WeightPrice>
)
