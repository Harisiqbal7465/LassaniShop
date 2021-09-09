package com.hidevelopers.lassanishop.presentation.ratelist.addownratelist

import androidx.compose.foundation.layout.Box
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
import androidx.navigation.NavController
import com.hidevelopers.lassanishop.R
import com.hidevelopers.lassanishop.presentation.components.StandardToolbar

@Composable
fun AddOwnRateListScreen(
    navController: NavController
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            StandardToolbar(
                navController = navController,
                showBackArrow = true,
                modifier = Modifier.fillMaxWidth(),
                title = {
                    Text(
                        text = stringResource(id = R.string.add_own_rate_list),
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.h1,
                        color = MaterialTheme.colors.onBackground,
                    )
                }
            )
        },

    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            LazyColumn {

            }
        }
    }
}