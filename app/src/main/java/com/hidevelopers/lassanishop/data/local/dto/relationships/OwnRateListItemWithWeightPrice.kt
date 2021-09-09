package com.hidevelopers.lassanishop.data.local.dto.relationships

import androidx.room.Embedded
import androidx.room.Relation
import com.hidevelopers.lassanishop.data.local.dto.OwnRateLIstItemDto
import com.hidevelopers.lassanishop.data.local.dto.WeightPriceDto

data class OwnRateListItemWithWeightPrice(
    @Embedded val ownRateListItem: OwnRateLIstItemDto,
    @Relation(
        parentColumn = "ownRateListItemId",
        entityColumn = "ownRateListItemId"
    )
    val weightPrice: List<WeightPriceDto>
)
