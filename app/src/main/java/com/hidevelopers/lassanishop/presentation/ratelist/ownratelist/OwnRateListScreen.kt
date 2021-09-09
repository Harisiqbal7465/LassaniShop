package com.hidevelopers.lassanishop.presentation.ratelist.ownratelist

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.hidevelopers.lassanishop.R
import com.hidevelopers.lassanishop.presentation.components.Screen
import com.hidevelopers.lassanishop.presentation.components.StandardScaffold
import com.hidevelopers.lassanishop.presentation.components.StandardToolbar

@Composable
fun OwnRateListScreen(
    navController: NavController,
    viewModel: OwnRateListViewModel = hiltViewModel()
) {
    val state = viewModel.getRateListItem.value

    viewModel.setTopBarName(
        if (state.isSuccess.first().ownRateListName.isNotEmpty())
            state.isSuccess.first().ownRateListName
        else
            stringResource(id = R.string.own_rate_list)
    )

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            StandardToolbar(
                navController = navController,
                showBackArrow = true,
                modifier = Modifier.fillMaxWidth(),
                title = {
                    Text(
                        text = viewModel.topBarName.value,
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.h1,
                        color = MaterialTheme.colors.onBackground,
                    )
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navController.navigate(Screen.AddOwnRateListScreen.route)
                },
                backgroundColor = MaterialTheme.colors.primary
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "")
            }
        },
        floatingActionButtonPosition = FabPosition.End
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            LazyColumn {
                items(state.isSuccess) {

                }
            }
        }
    }
}