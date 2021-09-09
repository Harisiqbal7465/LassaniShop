package com.hidevelopers.lassanishop.domain.use_case.list_feature.get_own_rate_list

import android.util.Log
import com.hidevelopers.lassanishop.common.Resource
import com.hidevelopers.lassanishop.data.local.dto.toOwnRateList
import com.hidevelopers.lassanishop.domain.model.OwnRateList
import com.hidevelopers.lassanishop.domain.repository.RateListRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import java.lang.Exception
import javax.inject.Inject

class GetRateListUseCase @Inject constructor(
    private val repository: RateListRepository
) {
    operator fun invoke(): Flow<Resource<List<OwnRateList>>> = flow {
        try {
            emit(Resource.Loading<List<OwnRateList>>())
            repository.getOwnRateList().collect { flow ->
                val rateList = flow.map { it.toOwnRateList() }
                emit(Resource.Success<List<OwnRateList>>(rateList))
            }
        } catch (e: Exception) {
            emit(Resource.Error<List<OwnRateList>>(e.message ?: "An unexpected error occured"))
        }
    }
}