package com.github.tallestlegacy.rickandmortykt.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun EpisodesScreen () {
    Scaffold()  { innerPadding ->
        Box(
            modifier = Modifier.padding(innerPadding),
            contentAlignment = Alignment.Center,
        ) {
            Text("Episodes")
        }
    }
}
