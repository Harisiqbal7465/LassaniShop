package com.hidevelopers.lassanishop.presentation.ratelist.addownratelist

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.hidevelopers.lassanishop.common.Resource
import com.hidevelopers.lassanishop.data.local.dto.OwnRateLIstItemDto
import com.hidevelopers.lassanishop.data.local.dto.WeightPriceDto
import com.hidevelopers.lassanishop.domain.use_case.list_feature.insert_own_rate_list_item.InsertOwnRateListItemUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class AddOwnRateList @Inject constructor(
    private val insertOwnRateListItemUseCase: InsertOwnRateListItemUseCase
) : ViewModel() {
    
    private val _insertOwnRateList = mutableStateOf<InsertOwnRateListState>(InsertOwnRateListState())
    val insertOwnRateList: State<InsertOwnRateListState> = _insertOwnRateList

    fun insertOwnRateList(ownRateListItem: OwnRateLIstItemDto, weightPriceDto: WeightPriceDto) {
        insertOwnRateListItemUseCase(ownRateListItem = ownRateListItem,weightPriceDto = weightPriceDto).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _insertOwnRateList.value = InsertOwnRateListState(isSuccess = Any())
                }
                is Resource.Error -> {
                    _insertOwnRateList.value = InsertOwnRateListState(error = result.message ?: "An unexpected error occured")
                }
                is Resource.Loading -> {
                    _insertOwnRateList.value = InsertOwnRateListState(isLoading = true)
                }
            }
        }
    }
}