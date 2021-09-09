package com.hidevelopers.lassanishop.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.hidevelopers.lassanishop.presentation.components.Navigation
import com.hidevelopers.lassanishop.presentation.components.Screen
import com.hidevelopers.lassanishop.presentation.components.StandardScaffold
import com.hidevelopers.lassanishop.presentation.ui.theme.LassaniShopTheme
import dagger.hilt.EntryPoint
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LassaniShopTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    color = MaterialTheme.colors.background,
                    modifier = Modifier.fillMaxSize()
                ) {
                    val navController = rememberNavController()
                    val navBackStackEntry by navController.currentBackStackEntryAsState()
                    StandardScaffold(
                        navController = navController,
                        showBottomBar = navBackStackEntry?.destination?.route in listOf(
                            Screen.ListScreen.route,
                            Screen.SearchScreen.route,
                            Screen.StockScreen.route,
                            Screen.SettingsScreen.route,
                        ),
                        modifier = Modifier.fillMaxSize(),

                        ) {
                        Navigation(navController)
                    }
                }
            }
        }
    }
}

