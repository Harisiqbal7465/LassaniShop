package com.hidevelopers.lassanishop.presentation.ratelist.ratelistinfo.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.hidevelopers.lassanishop.R
import com.hidevelopers.lassanishop.presentation.components.StandardToolbar
import com.hidevelopers.lassanishop.presentation.ratelist.ratelistinfo.RateListViewModel

@Composable
fun CustomToolbar(
    navController: NavController,
    viewModel: RateListViewModel = hiltViewModel()
) {
    StandardToolbar(
        navController = navController,
        title = {
            Text(
                text = stringResource(id = R.string.list_screen),
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.h1,
                color = MaterialTheme.colors.onBackground,
            )
        },
        modifier = Modifier.fillMaxWidth(),
        navAction = {
            IconButton(onClick = {
                viewModel.setOpenDialog(true)
            }) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "",
                    tint = MaterialTheme.colors.onBackground
                )
            }
            IconButton(onClick = { viewModel.setDropDownMenuExpend(true) }) {
                Icon(
                    imageVector = Icons.Default.FilterList,
                    contentDescription = "",
                    tint = MaterialTheme.colors.onBackground
                )
            }
            if (viewModel.dropDownMenuExpend.value) {
                DropdownMenu(
                    expanded = viewModel.dropDownMenuExpend.value,
                    onDismissRequest = {
                        viewModel.setDropDownMenuExpend(false)
                    }
                ) {
                    DropdownMenuItem(onClick = {
                        viewModel.setFilterCategory("company")
                    }) {
                        Text("Company")
                    }
                    DropdownMenuItem(onClick = {
                        viewModel.setFilterCategory("own")
                    }) {
                        Text("Own")
                    }
                }
            }
        }
    )
}