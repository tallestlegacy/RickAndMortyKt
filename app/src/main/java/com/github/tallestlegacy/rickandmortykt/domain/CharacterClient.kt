package com.github.tallestlegacy.rickandmortykt.api


interface CharacterClient {
    suspend fun getAllCharacters() : List<SimpleCharacter>
    suspend fun getCharacterById(id : Int) : DetailedCharacter
}



data class SimpleCharacter (
    var id: String?,
    var name: String,
    var image: String?
)


data class DetailedCharacter (
    var id : Int
)
