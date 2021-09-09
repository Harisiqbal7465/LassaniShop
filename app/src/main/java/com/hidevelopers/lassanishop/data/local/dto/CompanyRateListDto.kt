package com.hidevelopers.lassanishop.data.local.dto

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.hidevelopers.lassanishop.domain.model.CompanyRateList

@Entity(tableName = "tblCompanyRateList")
data class CompanyRateListDto(
    @PrimaryKey
    val companyRateListId: Int,
    val companyRateListName: String
){
    @Ignore
    val size: Long = 0L
}

fun CompanyRateListDto.toCompanyRateList(): CompanyRateList {
    return CompanyRateList(
        name = this.companyRateListName,
        size = this.size
    )
}