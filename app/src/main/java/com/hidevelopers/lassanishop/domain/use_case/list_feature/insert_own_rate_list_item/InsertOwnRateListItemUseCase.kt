package com.hidevelopers.lassanishop.domain.use_case.list_feature.insert_own_rate_list_item

import com.hidevelopers.lassanishop.common.Resource
import com.hidevelopers.lassanishop.data.local.dto.OwnRateLIstItemDto
import com.hidevelopers.lassanishop.data.local.dto.WeightPriceDto
import com.hidevelopers.lassanishop.domain.repository.RateListRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.Exception
import javax.inject.Inject

class InsertOwnRateListItemUseCase @Inject constructor(
    private val repository: RateListRepository
) {
    operator fun invoke(ownRateListItem: OwnRateLIstItemDto,weightPriceDto: WeightPriceDto): Flow<Resource<Any>> = flow {
        try {
            emit(Resource.Loading<Any>())
            repository.insertOwnRateListItem(ownRateListItem = ownRateListItem)
            repository.insertWeightPrice(weightPrice = weightPriceDto)
            emit(Resource.Success<Any>(Any()))
        } catch (e: Exception) {
            emit(Resource.Error<Any>(e.message ?: "An unexpected error occured"))
        }
    }
}