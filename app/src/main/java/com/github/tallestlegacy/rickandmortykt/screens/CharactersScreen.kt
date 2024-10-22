package com.github.tallestlegacy.rickandmortykt.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.github.tallestlegacy.rickandmortykt.api.ApolloCharacterClient
import com.github.tallestlegacy.rickandmortykt.api.apolloClient
import com.github.tallestlegacy.rickandmortykt.components.shared.CharacterCard
import com.github.tallestlegacy.rickandmortykt.domain.SimpleCharacter
import compose.icons.FeatherIcons
import compose.icons.feathericons.RefreshCw
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CharactersScreen() {

    val client = ApolloCharacterClient(apolloClient)
    var resText by remember { mutableStateOf<String>("") }
    var characters by remember { mutableStateOf<List<SimpleCharacter>>(listOf()) }

    var verticalScrollModifier = rememberScrollState()

    var fetchCharacters = {
        resText = "Loading ..."
        CoroutineScope(Dispatchers.IO).launch {
            var res = client.getAllCharacters()
            if (!res.results.isNullOrEmpty())
                characters = res.results as List<SimpleCharacter>
        }
    }

    fetchCharacters()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Characters") },
                actions = {
                    Row {
                        IconButton(onClick = { fetchCharacters() }) {
                            Icon(FeatherIcons.RefreshCw, contentDescription = "Refresh")
                        }
                    }
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .verticalScroll(verticalScrollModifier)
                .fillMaxSize(),

        ) {
            for (character in characters) {
                CharacterCard(character)
            }
        }
    }
}