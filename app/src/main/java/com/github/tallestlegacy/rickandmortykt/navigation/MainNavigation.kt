package com.github.tallestlegacy.rickandmortykt.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.github.tallestlegacy.rickandmortykt.screens.CharactersScreen
import com.github.tallestlegacy.rickandmortykt.screens.EpisodesScreen
import com.github.tallestlegacy.rickandmortykt.screens.LocationsScreen
import compose.icons.FeatherIcons
import compose.icons.feathericons.Compass
import compose.icons.feathericons.List
import compose.icons.feathericons.Users


data class Tab(
    val route: String,
    val text: String,
    val icon: ImageVector,
)


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
) {

    var navController = rememberNavController()
    val tabs = listOf(
        Tab(
            text = "Characters",
            route = MainTabs.Characters.route,
            icon = FeatherIcons.Users,
        ),
        Tab(
            text = "Locations",
            route = MainTabs.Locations.route,
            icon = FeatherIcons.Compass,
        ),
        Tab(
            text = "Episodes",
            route = MainTabs.Episodes.route,
            icon = FeatherIcons.List,
        )
    )


    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route ?: ""

    Scaffold(
        topBar = {
        },
        bottomBar = {
            NavigationBar {

                for (tab in tabs) {
                    NavigationBarItem(
                        icon = { Icon(tab.icon, tab.route) },
                        selected = tab.route == currentRoute,
                        onClick = {
                            navController.navigate(tab.route) {
                                launchSingleTop = true
                                restoreState = true
                                popUpTo(navController.graph.startDestinationId) {
                                    saveState = true
                                }
                            }
                        }
                    )
                }
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = MainTabs.Locations.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(route = MainTabs.Locations.route) { LocationsScreen() }
            composable(route = MainTabs.Episodes.route) { EpisodesScreen() }
            composable(route = MainTabs.Characters.route) { CharactersScreen() }
        }
    }
}

