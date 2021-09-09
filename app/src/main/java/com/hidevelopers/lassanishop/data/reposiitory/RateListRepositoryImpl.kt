package com.hidevelopers.lassanishop.data.reposiitory

import com.hidevelopers.lassanishop.data.local.ShopDao
import com.hidevelopers.lassanishop.data.local.dto.*
import com.hidevelopers.lassanishop.data.local.dto.relationships.OwnRateListItemWithWeightPrice
import com.hidevelopers.lassanishop.data.local.dto.relationships.OwnRateListWithOwnRateListItemAndWeighPrice
import com.hidevelopers.lassanishop.domain.repository.RateListRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RateListRepositoryImpl @Inject constructor(
    private val dao: ShopDao
): RateListRepository {
    override suspend fun insertOwnRateList(ownRateList: OwnRateListDto) {
        dao.insertOwnRateList(onwRateList = ownRateList)
    }

    override suspend fun insertOwnRateListItem(ownRateListItem: OwnRateLIstItemDto) {
        dao.insertOwnRateListItem(ownRateListItem = ownRateListItem)
    }

    override suspend fun insertCompanyRateList(companyRateList: CompanyRateListDto) {
        dao.insertCompanyRateList(companyRateList = companyRateList)
    }

    override suspend fun insertCompanyRateListItem(companyRateListItem: CompanyRateListItemDto) {
        dao.insertCompanyRateListItem(companyRateListItem = companyRateListItem)
    }

    override suspend fun insertWeightPrice(weightPrice: WeightPriceDto) {
        dao.insertWeightPrice(weightPrice = weightPrice)
    }

    override suspend fun getOwnRateList(): Flow<List<OwnRateListDto>> {
        return dao.getOwnRateList()
    }

    override suspend fun getCompanyRateList(): Flow<List<CompanyRateListDto>> {
        return dao.getCompanyRateList()
    }

    override suspend fun getSizeOwnRateList(): Flow<Long> {
        return dao.getSizeOwnRateList()
    }

    override suspend fun getSizeCompanyRateList(): Flow<Long> {
        return dao.getSizeCompanyRateList()
    }

    override suspend fun getOwnRateListWithOwnRateListItemAndWeightPrice(ownRateListId: Int): Flow<List<OwnRateListWithOwnRateListItemAndWeighPrice>> {
        return dao.getOwnRateListWithRateListItemAndWeightPrice(ownRateListId = ownRateListId)
    }
}