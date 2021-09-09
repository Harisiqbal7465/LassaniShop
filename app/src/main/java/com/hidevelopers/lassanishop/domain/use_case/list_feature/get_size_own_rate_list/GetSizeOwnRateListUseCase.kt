package com.hidevelopers.lassanishop.domain.use_case.list_feature.get_size_own_rate_list

import android.util.Log
import com.hidevelopers.lassanishop.common.Resource
import com.hidevelopers.lassanishop.domain.repository.RateListRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetSizeOwnRateListUseCase @Inject constructor(
    private val repository: RateListRepository
){
    operator fun invoke(): Flow<Resource<Long>> = flow {
        Log.i("check","in get size use case")
        try {
            emit(Resource.Loading<Long>())
            repository.getSizeOwnRateList().collect {
                emit(Resource.Success<Long>(it))
            }
        } catch (e: Exception) {
            emit(Resource.Error<Long>(e.message ?: "An unexpected error occured"))
        }
    }
}