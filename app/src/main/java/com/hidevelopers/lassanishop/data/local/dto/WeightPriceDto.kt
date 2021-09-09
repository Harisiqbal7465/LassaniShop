package com.hidevelopers.lassanishop.data.local.dto

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class WeightPriceDto(
    @PrimaryKey
    val weightPriceId: Int,
    val weight: Long,
    val price: Long,
    val ownRateListItemId: Int
)
