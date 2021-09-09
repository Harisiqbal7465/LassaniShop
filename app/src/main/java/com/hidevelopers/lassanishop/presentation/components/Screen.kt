package com.hidevelopers.lassanishop.presentation.components

sealed class Screen(val route: String){
    object ListScreen: Screen("List_screen")
    object SettingsScreen: Screen("setting_screen")
    object StockScreen: Screen("stock_screen")
    object SearchScreen: Screen("search_screen")
    object OwnRateListScreen: Screen("own_rate_list_item_screen")
    object AddOwnRateListScreen: Screen("add_own_rate_list_screen")
}
