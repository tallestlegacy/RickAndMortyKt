package com.github.tallestlegacy.rickandmortykt.domain

import com.github.tallestlegacy.rickandmortykt.GetCharactersQuery


interface CharacterClient {
    suspend fun getAllCharacters(): DomainResponse<SimpleCharacter>
    suspend fun getCharacterById(id: Int): DetailedCharacter
}


data class SimpleCharacter(
    var id: String?,
    var name: String?,
    var image: String?,
    var gender: String?,
    var species: String?,
)

fun GetCharactersQuery.Result.toSimpleCharacter(): SimpleCharacter {
    return SimpleCharacter(
        id = id,
        name = name,
        image = image,
        gender = gender,
        species = species
    )
}

fun GetCharactersQuery.Info.toinfo(): PaginationInfo {
    return PaginationInfo(
        count = count,
        pages = pages,
        next = next.toString(),
        prev = prev.toString()
    )
}


data class DetailedCharacter(
    var id: Int,
)
