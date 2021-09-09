package com.hidevelopers.lassanishop.data.local.dto

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "tblCompanyRateListItem")
data class CompanyRateListItemDto(
    @PrimaryKey
    val companyRateListItemId: Int,
    val companyRateListItemName: String,
    val companyRateListId: Int
)
