package com.github.tallestlegacy.rickandmortykt.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.github.tallestlegacy.rickandmortykt.api.ApolloCharacterClient
import com.github.tallestlegacy.rickandmortykt.api.apolloClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
fun CharactersScreen() {

    val client = ApolloCharacterClient(apolloClient)
    var restext by remember { mutableStateOf<String>("") }

    Scaffold() { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding),
        ) {
            Button(onClick = {
                restext = "Loading ..."
                CoroutineScope(Dispatchers.IO).launch {
                    var res = client.getAllCharacters()
                    restext = res.toString()
                }
            }) {
                Text("Characters")
            }
            Text(restext)
        }
    }
}