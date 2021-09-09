package com.hidevelopers.lassanishop.presentation.components

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun StandardToolbar(
    navController: NavController,
    modifier: Modifier = Modifier,
    showBackArrow: Boolean = false,
    navAction: @Composable RowScope.() -> Unit = {},
    title: @Composable () -> Unit = {},
) {
    TopAppBar(
        title = title,
        modifier = modifier,
        navigationIcon = if (showBackArrow) {
            {
                IconButton(onClick = { navController.navigateUp() }) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "",
                        tint = MaterialTheme.colors.onBackground
                    )
                }
            }
        } else null,
        actions = navAction,
        backgroundColor = MaterialTheme.colors.surface,
        elevation = 0.dp
    )
}