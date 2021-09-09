package com.hidevelopers.lassanishop.data.local.dto.relationships

import androidx.room.Embedded
import androidx.room.Relation
import com.hidevelopers.lassanishop.data.local.dto.OwnRateLIstItemDto
import com.hidevelopers.lassanishop.data.local.dto.OwnRateListDto
import com.hidevelopers.lassanishop.domain.model.OwnRateListById
import com.hidevelopers.lassanishop.domain.model.WeightPrice

data class OwnRateListWithOwnRateListItemAndWeighPrice(
    @Embedded val ownRateListDao: OwnRateListDto,
    @Relation(
        entity = OwnRateLIstItemDto::class,
        parentColumn = "ownRateListId",
        entityColumn = "ownRateListId"
    )
    val ownRateListWithOwnRateListItemAndWeightPrice: List<OwnRateListItemWithWeightPrice>
)

fun OwnRateListWithOwnRateListItemAndWeighPrice.toOwnRateListById(): OwnRateListById {
    var ownRateListItemName: String = ""
    val weighPrice: List<WeightPrice> = mutableListOf()
    ownRateListWithOwnRateListItemAndWeightPrice.forEach { list ->
        ownRateListItemName = list.ownRateListItem.ownRateListItemName
        weighPrice.map {
            list.weightPrice.forEach { weightPriceDto ->
                it.price = weightPriceDto.price
                it.weight = weightPriceDto.weight
            }
        }
    }
    return OwnRateListById(
        ownRateListId = ownRateListDao.ownRateListId,
        ownRateListName = ownRateListDao.ownRateListName,
        ownRateListItemName = ownRateListItemName,
        weightPrice = weighPrice
    )
}
