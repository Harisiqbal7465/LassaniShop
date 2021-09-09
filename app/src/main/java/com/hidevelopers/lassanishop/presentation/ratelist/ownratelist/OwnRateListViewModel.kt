package com.hidevelopers.lassanishop.presentation.ratelist.ownratelist

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.hidevelopers.lassanishop.common.Constants
import com.hidevelopers.lassanishop.common.Resource
import com.hidevelopers.lassanishop.domain.model.OwnRateListById
import com.hidevelopers.lassanishop.domain.use_case.list_feature.get_own_rate_list_item.GetOwnRateListItemByIdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class OwnRateListViewModel @Inject constructor(
    private val getRateListItemUseCase: GetOwnRateListItemByIdUseCase,
    private val savedStatedHandled: SavedStateHandle
): ViewModel() {

    private val _topBarName = mutableStateOf<String>("")
    val topBarName: State<String> = _topBarName

    private val _getRateListItem = mutableStateOf(OwnRateListItemSate())
    val getRateListItem: State<OwnRateListItemSate> = _getRateListItem
    
    init {
        savedStatedHandled.get<String>(Constants.PARAM_COIN_ID)?.let { ownRateListId ->
            getOwnRateListItem(ownRateListId = ownRateListId.toInt())
        }
    }

    private fun getOwnRateListItem(ownRateListId: Int) {
        getRateListItemUseCase(ownRateListId = ownRateListId).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _getRateListItem.value = OwnRateListItemSate(isSuccess = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    _getRateListItem.value = OwnRateListItemSate(error = result.message ?: "An unexpected error occured")
                }
                is Resource.Loading -> {
                    _getRateListItem.value = OwnRateListItemSate(isLoading = true)
                }
            }
        }
    }

    fun setTopBarName(name: String) {
        _topBarName.value = name
    }
}