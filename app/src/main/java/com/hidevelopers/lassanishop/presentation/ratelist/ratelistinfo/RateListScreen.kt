package com.hidevelopers.lassanishop.presentation.ratelist.ratelistinfo


import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.hidevelopers.lassanishop.presentation.components.Screen
import com.hidevelopers.lassanishop.presentation.ratelist.ratelistinfo.components.CustomAlertBox
import com.hidevelopers.lassanishop.presentation.ratelist.ratelistinfo.components.CustomToolbar
import com.hidevelopers.lassanishop.presentation.ratelist.ratelistinfo.components.RateListInfoRow


@Composable
fun RateListScreen(
    navController: NavController,
    viewModel: RateListViewModel = hiltViewModel()
) {
    val radioButtonOptions = listOf("Company", "Own")
    val (selectedOption, onOptionSelected) = remember { mutableStateOf(radioButtonOptions[0]) }
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        CustomToolbar(navController = navController)
        RateListInfoList(navController = navController)
    }
    if (viewModel.openDialog.value) {
        CustomAlertBox(
            navController,
            openDialog = { viewModel.setOpenDialog(it) },
            radioButtonOptions = radioButtonOptions,
            selectedOption = selectedOption,
            onOptionSelected = onOptionSelected,
            listName = viewModel.listName.value,
            onListNameChange = { viewModel.setListName(it) }
        )
    }
}

@Composable
fun RateListInfoList(
    viewModel: RateListViewModel = hiltViewModel(),
    navController: NavController
) {
    Box(modifier = Modifier.fillMaxSize()) {
        if (viewModel.filterCategory.value == "own") {
            val ownRateList = viewModel.getOwnRateListState.value
            when {
                ownRateList.isLoading -> {
                    CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
                }
                ownRateList.error.isNotBlank() -> {
                    Text(text = ownRateList.error)
                }
                else -> {
                    LazyColumn {
                        ownRateList.result?.let { resultList ->
                            Log.i("check", "size = ${resultList.size}")
                            itemsIndexed(resultList) { index, rateList ->
                                RateListInfoRow(
                                    rateListName = rateList.name,
                                    rateListSize = rateList.size,
                                    index + 1L
                                ) {
                                    navController.navigate(Screen.OwnRateListScreen.route)
                                }
                            }
                        }
                    }

                }
            }
        } else if (viewModel.filterCategory.value == "company") {
            //        val companyRateList by viewModel.companyRateListInfoList.observeAsState()
            //        RateListRow(rateList = listOf(""))
        }
    }
}


