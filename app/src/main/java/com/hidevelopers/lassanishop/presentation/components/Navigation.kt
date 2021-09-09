package com.hidevelopers.lassanishop.presentation.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.hidevelopers.lassanishop.presentation.ratelist.addownratelist.AddOwnRateListScreen
import com.hidevelopers.lassanishop.presentation.ratelist.ownratelist.OwnRateListScreen
import com.hidevelopers.lassanishop.presentation.ratelist.ratelistinfo.RateListScreen

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.ListScreen.route,
        modifier = Modifier.fillMaxSize()
    ) {
        composable(Screen.ListScreen.route){
            RateListScreen(navController = navController)
        }
        composable(Screen.SearchScreen.route){
            //SearchScreen(navController = navController)
        }
        composable(Screen.StockScreen.route){
            //StockScreen(navController = navController)
        }
        composable(Screen.SettingsScreen.route){
            //SettingsScreen(navController = navController)
        }
        composable(Screen.OwnRateListScreen.route) {
            OwnRateListScreen(navController = navController)
        }
        composable(Screen.AddOwnRateListScreen.route) {
            AddOwnRateListScreen(navController = navController)
        }
    }
}