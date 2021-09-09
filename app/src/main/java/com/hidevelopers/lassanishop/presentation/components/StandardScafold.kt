package com.hidevelopers.lassanishop.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.BottomAppBar
import androidx.compose.material.BottomNavigation
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.List
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.hidevelopers.lassanishop.R
import com.hidevelopers.lassanishop.domain.model.BottomNavItem

@Composable
fun StandardScaffold(
    navController: NavController,
    modifier: Modifier = Modifier,
    showBottomBar: Boolean = true,
    bottomNavItems: List<BottomNavItem> = listOf(

        BottomNavItem(
            route = Screen.ListScreen.route,
            icon = Icons.Outlined.List,
            contentDescription = "List",
        ),

        BottomNavItem(
            route = Screen.SearchScreen.route,
            icon = Icons.Outlined.Search,
            contentDescription = "Search"
        ),

        BottomNavItem(
            route = Screen.StockScreen.route,
            icon =  ImageVector.vectorResource(id = R.drawable.ic_storage_24),
            contentDescription = "Stock"
        ),

        BottomNavItem(
            route = Screen.SettingsScreen.route,
            icon = Icons.Outlined.Settings,
            contentDescription = "Settings"
        )

    ),
    content: @Composable () -> Unit
) {
    Scaffold(
        bottomBar = {
            if(showBottomBar){
                BottomAppBar(
                    modifier = Modifier.fillMaxWidth(),
                    backgroundColor = MaterialTheme.colors.surface,
                    cutoutShape = CircleShape,
                    elevation = 5.dp
                ) {
                    BottomNavigation {
                        bottomNavItems.forEachIndexed { i, bottomNavItem ->
                            StandardBottomNavItem(
                                icon = bottomNavItem.icon,
                                contentDescription = bottomNavItem.contentDescription,
                                selected = bottomNavItem.route == navController.currentDestination?.route,
                                alertCount = bottomNavItem.alertCount,
                                enabled = bottomNavItem.icon != null
                            ) {
                                if (navController.currentDestination?.route != bottomNavItem.route) {
                                    navController.navigate(bottomNavItem.route)
                                }
                            }
                        }
                    }
                }
            }
        },
        modifier = modifier
    ) {
        content()
    }
}
