package com.github.tallestlegacy.rickandmortykt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.github.tallestlegacy.rickandmortykt.navigation.SetUpNavGraph
import com.github.tallestlegacy.rickandmortykt.ui.theme.RickAndMortyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RickAndMortyTheme (dynamicColor = true) {
                var navController = rememberNavController()
                SetUpNavGraph(navController = navController)
            }
        }
    }
}
