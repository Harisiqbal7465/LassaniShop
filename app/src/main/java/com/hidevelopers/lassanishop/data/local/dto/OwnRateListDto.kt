package com.hidevelopers.lassanishop.data.local.dto

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.hidevelopers.lassanishop.domain.model.OwnRateList

@Entity(tableName = "tblOwnRateList")
data class OwnRateListDto(
    @PrimaryKey(autoGenerate = true)
    val ownRateListId: Int,
    val ownRateListName: String
) {
    @Ignore
    var sizeList: Long = 0
}

fun OwnRateListDto.toOwnRateList(): OwnRateList {
    return OwnRateList(
        name = this.ownRateListName,
        size = sizeList
    )
}