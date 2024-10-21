package com.github.tallestlegacy.rickandmortykt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.github.tallestlegacy.rickandmortykt.ui.theme.RickAndMortyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RickAndMortyTheme (dynamicColor = true) {
                Scaffold { innerPadding ->
                    Greeter("Marvin", modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun Greeter (name : String, modifier : Modifier) {
    Box( modifier = modifier, ) {
        Text(text = "Hello, $name!!!")
    }
}