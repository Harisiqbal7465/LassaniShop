package com.hidevelopers.lassanishop.domain.use_case.list_feature.get_own_rate_list_item

import com.hidevelopers.lassanishop.common.Resource
import com.hidevelopers.lassanishop.data.local.dto.relationships.toOwnRateListById
import com.hidevelopers.lassanishop.domain.model.OwnRateListById
import com.hidevelopers.lassanishop.domain.repository.RateListRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import java.lang.Exception
import javax.inject.Inject

class GetOwnRateListItemByIdUseCase @Inject constructor(
    private val repository: RateListRepository
) {
    operator fun invoke(ownRateListId: Int): Flow<Resource<List<OwnRateListById>>> = flow {
        try {
            emit(Resource.Loading())
            repository.getOwnRateListWithOwnRateListItemAndWeightPrice(ownRateListId = ownRateListId)
                .collect { list ->
                    val result = list.map {
                        it.toOwnRateListById()
                    }
                    emit(Resource.Success(result))
                }
        } catch (e: Exception) {
            emit(Resource.Error(e.message ?: "An unexpected error occured"))
        }
    }
}