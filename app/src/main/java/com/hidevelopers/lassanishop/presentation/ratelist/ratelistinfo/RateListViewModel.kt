package com.hidevelopers.lassanishop.presentation.ratelist.ratelistinfo

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hidevelopers.lassanishop.common.Resource
import com.hidevelopers.lassanishop.data.local.dto.OwnRateListDto
import com.hidevelopers.lassanishop.domain.model.OwnRateList
import com.hidevelopers.lassanishop.domain.repository.RateListRepository
import com.hidevelopers.lassanishop.domain.use_case.list_feature.get_own_rate_list.GetRateListUseCase
import com.hidevelopers.lassanishop.domain.use_case.list_feature.get_size_own_rate_list.GetSizeOwnRateListUseCase
import com.hidevelopers.lassanishop.domain.use_case.list_feature.insert_own_rate_list.InsetOwnRateListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class RateListViewModel @Inject constructor(
       private val insertOnwRateListUseCase: InsetOwnRateListUseCase,
       private val getOwnRateListUseCase: GetRateListUseCase,
       private val getSizeOwnRateListUseCase: GetSizeOwnRateListUseCase,
       private val repository: RateListRepository
) : ViewModel() {

    private var _openDialog = mutableStateOf(false)
    val openDialog: State<Boolean> = _openDialog

    private val _listName = mutableStateOf("")
    var listName: State<String> = _listName

    private val _dropDownMenuExpend = mutableStateOf<Boolean>(false)
    val dropDownMenuExpend: State<Boolean> = _dropDownMenuExpend

    private val _filterCategory = mutableStateOf("own")
    val filterCategory: State<String> = _filterCategory

    private val _dialogErrorMessage = mutableStateOf<String>("")
    val dialogErrorMessage: State<String> = _dialogErrorMessage

    private val _getOwnRateListState = mutableStateOf<RateListState<List<OwnRateList>>>(
        RateListState()
    )
    val getOwnRateListState: State<RateListState<List<OwnRateList>>> = _getOwnRateListState

   /* private val _getOwnRateListState = mutableStateOf(OwnRateListState())
    val getOwnRateListState: State<OwnRateListState> = _getOwnRateListState*/
    private val _getCompanyRateListState = mutableStateOf(CompanyRateListState())
    val getCompanyRateList: State<CompanyRateListState> = _getCompanyRateListState

    private val _getSizeOwnRateListState = mutableStateOf(SizeOwnRateListState())
    val getSizeOwnRateList: State<SizeOwnRateListState> = _getSizeOwnRateListState
    
    private val _insertOwnRateListState = mutableStateOf(OwnRateListState())
    val insertOwnRateListState: State<OwnRateListState> = _insertOwnRateListState
    
    init {
        getOwnRateList()
        getSizeOwnRateList()
        //getSizeOwnRateList()
    }

    private fun getOwnRateList() {
        getOwnRateListUseCase().onEach{ result ->
            when(result){
                is Resource.Success -> {
                    _getOwnRateListState.value = RateListState(result = result.data )
                    Log.i("check","in view Model getting list")
                }
                is Resource.Error -> {
                    _getOwnRateListState.value = RateListState(error = result.message ?: "An unexpected error occured")
                }
                is Resource.Loading -> {
                    _getOwnRateListState.value = RateListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
    
    private fun getSizeOwnRateList() {
        getSizeOwnRateListUseCase().onEach{ result ->
            when(result) {
                is Resource.Success -> {
                    _getSizeOwnRateListState.value = SizeOwnRateListState(isSuccess = result.data ?: 0)
                }
                is Resource.Error -> {
                    _getSizeOwnRateListState.value = SizeOwnRateListState(error = result.message ?: "An unexpected error occured")
                }
                is Resource.Loading -> {
                    _getSizeOwnRateListState.value = SizeOwnRateListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }

    fun insertOnwRateList(ownRateList: OwnRateListDto) {
        insertOnwRateListUseCase(ownRateList).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _insertOwnRateListState.value = OwnRateListState(isSuccess = emptyList())
                }
                is Resource.Error -> {
                    _insertOwnRateListState.value = OwnRateListState(error = result.message ?: "An unexpected error occured")
                }
                is Resource.Loading -> {
                    _insertOwnRateListState.value = OwnRateListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }

    fun setDialogErrorMessage(errorMessage: String) {
        _dialogErrorMessage.value = errorMessage
    }

    fun setDropDownMenuExpend(openExpend: Boolean) {
        _dropDownMenuExpend.value = openExpend
    }

    fun setOpenDialog(openDialog: Boolean) {
        _openDialog.value = openDialog
    }

    fun setListName(listName: String) {
        _listName.value = listName
    }

    fun setFilterCategory(filterCategory: String) {
        _filterCategory.value = filterCategory
    }
}