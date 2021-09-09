package com.hidevelopers.lassanishop.data.local.dto.relationships

import androidx.room.Embedded
import androidx.room.Relation
import com.hidevelopers.lassanishop.data.local.dto.CompanyRateListDto
import com.hidevelopers.lassanishop.data.local.dto.CompanyRateListItemDto

data class CompanyRateListWithCompanyRateListItem(
    @Embedded val companyRateList: CompanyRateListDto,
    @Relation(
        parentColumn = "companyRateListId",
        entityColumn = "companyRateListId"
    )
    val companyRateLIstItem: List<CompanyRateListItemDto>
)
