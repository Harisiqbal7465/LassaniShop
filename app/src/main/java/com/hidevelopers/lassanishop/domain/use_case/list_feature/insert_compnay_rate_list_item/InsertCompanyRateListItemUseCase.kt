package com.hidevelopers.lassanishop.domain.use_case.list_feature.insert_compnay_rate_list_item

import com.hidevelopers.lassanishop.common.Resource
import com.hidevelopers.lassanishop.data.local.dto.CompanyRateListItemDto
import com.hidevelopers.lassanishop.domain.repository.RateListRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.Exception
import javax.inject.Inject

class InsertCompanyRateListItemUseCase @Inject constructor(
    private val repository: RateListRepository
){
    operator fun invoke(companyRateListItem: CompanyRateListItemDto) : Flow<Resource<Any>> = flow {
        try {
            emit(Resource.Loading<Any>())
            repository.insertCompanyRateListItem(companyRateListItem = companyRateListItem)
            emit(Resource.Success<Any>(Any()))
        } catch (e: Exception) {
            emit(Resource.Error<Any>(e.message ?: "An unexpected error occured"))
        }
    }
}
