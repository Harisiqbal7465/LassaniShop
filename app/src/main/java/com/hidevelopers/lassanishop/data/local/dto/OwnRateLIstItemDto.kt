package com.hidevelopers.lassanishop.data.local.dto

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tblOwnRateListItem")
data class OwnRateLIstItemDto(
    @PrimaryKey
    val ownRateListItemId: Int,
    val ownRateListItemName: String,
    val ownRateListId: Int,
)
