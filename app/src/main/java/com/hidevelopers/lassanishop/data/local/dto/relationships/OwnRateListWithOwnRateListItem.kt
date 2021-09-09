package com.hidevelopers.lassanishop.data.local.dto.relationships

import androidx.room.Embedded
import androidx.room.Relation
import com.hidevelopers.lassanishop.data.local.dto.OwnRateLIstItemDto
import com.hidevelopers.lassanishop.data.local.dto.OwnRateListDto


data class OwnRateListWithOwnRateListItem(
    @Embedded val ownRateList: OwnRateListDto,
    @Relation(
        parentColumn = "ownRateListId",
        entityColumn = "ownRateListId"
    )
    val ownRateListItem: List<OwnRateLIstItemDto>
)
