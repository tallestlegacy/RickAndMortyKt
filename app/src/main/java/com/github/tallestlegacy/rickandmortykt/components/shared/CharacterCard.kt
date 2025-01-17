package com.github.tallestlegacy.rickandmortykt.components.shared

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.github.tallestlegacy.rickandmortykt.domain.SimpleCharacter

@Composable
fun CharacterCard(character: SimpleCharacter) {
    return Card(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {

            Text(text = character.name as String)
            Text(text = character.gender as String)
            Text(text = character.species as String)

            AsyncImage(
                model = character.image as String,
                contentDescription = null,
                modifier = Modifier
                    .height(200.dp)
                    .background(MaterialTheme.colorScheme.secondaryContainer)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(16.dp))
            )
        }
    }
}


@Composable
@Preview(showBackground = true)
fun CharacterCardPreview() {
    return CharacterCard(
        SimpleCharacter(
            id = "1",
            name = "Rick Sanchez",
            image = "https://rickandmortyapi.com/api/character/avatar/1.jpeg",
            species = "Human",
            gender = "Male"
        )
    )
}