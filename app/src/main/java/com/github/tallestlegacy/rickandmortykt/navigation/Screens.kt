package com.github.tallestlegacy.rickandmortykt.navigation

sealed class Screen(val route: String) {
    data object Home : Screen("home_screen")
    data object  Character : Screen("character_screen")
    data object  Location : Screen("location_screen")
    data object  Episode : Screen("episode_screen")
}


sealed class MainTabs(val route :String) {
    data object Characters : MainTabs("characters_screen")
    data object Locations : MainTabs("locations_screen")
    data object Episodes : MainTabs("episodes_screen")

}