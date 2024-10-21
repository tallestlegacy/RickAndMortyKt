package com.github.tallestlegacy.rickandmortykt.api

import com.apollographql.apollo.ApolloClient
import com.github.tallestlegacy.rickandmortykt.GetCharactersQuery


class ApolloCharacterClient(
    private val apolloClient: ApolloClient
) : CharacterClient {
    override suspend fun getAllCharacters(): List<SimpleCharacter> {
        return apolloClient
            .query(GetCharactersQuery(page = 1))
            .execute()
            ?.data
            ?.characters
            ?.results
            ?.map {
                it?.toSimpleCharacter() as SimpleCharacter
            }
            ?: emptyList()
    }

    override suspend fun getCharacterById(id: Int): DetailedCharacter {
        TODO("Not yet implemented")
    }
}


fun GetCharactersQuery.Result.toSimpleCharacter() : SimpleCharacter {
    return SimpleCharacter (
            id = id,
            name = name.toString(),
            image = image
    )
}
