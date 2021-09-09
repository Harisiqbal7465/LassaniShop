package com.hidevelopers.lassanishop.domain.use_case.list_feature.insert_compnay_rate_list

import com.hidevelopers.lassanishop.common.Resource
import com.hidevelopers.lassanishop.data.local.dto.CompanyRateListDto
import com.hidevelopers.lassanishop.domain.repository.RateListRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class InsertCompanyRateListUseCase @Inject constructor(
    private val repository: RateListRepository
) {
    operator fun invoke (companyRateListDto: CompanyRateListDto): Flow<Resource<Any>> = flow {
        try {
            emit(Resource.Loading<Any>())
            repository.insertCompanyRateList(companyRateList = companyRateListDto)
            emit(Resource.Success<Any>(Any()))
        } catch (e: Exception) {
            emit(Resource.Error<Any>(e.message ?: "An unexpected error occured"))
        }
    }
}