package com.hidevelopers.lassanishop.domain.use_case.list_feature.get_company_rate_list

import com.hidevelopers.lassanishop.common.Resource
import com.hidevelopers.lassanishop.data.local.dto.toCompanyRateList
import com.hidevelopers.lassanishop.domain.model.CompanyRateList
import com.hidevelopers.lassanishop.domain.repository.RateListRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import java.lang.Exception
import javax.inject.Inject

class GetCompanyRateListUseCase @Inject constructor(
    private val repository: RateListRepository
) {
    operator fun invoke () : Flow<Resource<List<CompanyRateList>>> = flow {
        try {
            emit(Resource.Loading<List<CompanyRateList>>())
            repository.getCompanyRateList().collect { flow ->
                val result = flow.map { it.toCompanyRateList() }
                emit(Resource.Success<List<CompanyRateList>>(result))
            }
        } catch (e: Exception) {
            emit(Resource.Error<List<CompanyRateList>>(e.message ?: "An unexpected error occured"))
        }
    }
}