package com.hidevelopers.lassanishop.domain.repository

import com.hidevelopers.lassanishop.data.local.dto.*
import com.hidevelopers.lassanishop.data.local.dto.relationships.OwnRateListItemWithWeightPrice
import com.hidevelopers.lassanishop.data.local.dto.relationships.OwnRateListWithOwnRateListItemAndWeighPrice
import kotlinx.coroutines.flow.Flow

interface RateListRepository {
    suspend fun insertOwnRateList(ownRateList: OwnRateListDto)
    suspend fun insertOwnRateListItem(ownRateListItem: OwnRateLIstItemDto)
    suspend fun insertCompanyRateList(companyRateList: CompanyRateListDto)
    suspend fun insertCompanyRateListItem(companyRateListItem: CompanyRateListItemDto)
    suspend fun insertWeightPrice(weightPrice: WeightPriceDto)

    suspend fun getOwnRateList(): Flow<List<OwnRateListDto>>
    suspend fun getCompanyRateList(): Flow<List<CompanyRateListDto>>
    suspend fun getSizeOwnRateList(): Flow<Long>
    suspend fun getSizeCompanyRateList(): Flow<Long>
    suspend fun getOwnRateListWithOwnRateListItemAndWeightPrice(ownRateListId: Int): Flow<List<OwnRateListWithOwnRateListItemAndWeighPrice>>
}