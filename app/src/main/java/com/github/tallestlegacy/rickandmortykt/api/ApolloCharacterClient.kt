package com.github.tallestlegacy.rickandmortykt.api

import android.util.Log
import com.apollographql.apollo.ApolloClient
import com.github.tallestlegacy.rickandmortykt.GetCharactersQuery
import com.github.tallestlegacy.rickandmortykt.domain.CharacterClient
import com.github.tallestlegacy.rickandmortykt.domain.DetailedCharacter
import com.github.tallestlegacy.rickandmortykt.domain.DomainResponse
import com.github.tallestlegacy.rickandmortykt.domain.SimpleCharacter
import com.github.tallestlegacy.rickandmortykt.domain.toSimpleCharacter
import com.github.tallestlegacy.rickandmortykt.domain.toinfo


class ApolloCharacterClient(
    private val apolloClient: ApolloClient,
) : CharacterClient {
    override suspend fun getAllCharacters(): DomainResponse<SimpleCharacter> {
        var res = apolloClient
            .query(GetCharactersQuery(page = 1))
            .execute()
            ?.data?.characters

        Log.d("ApolloCharacterClient", "getAllCharacter")
        return DomainResponse<SimpleCharacter>(
            results = res?.results?.map { it?.toSimpleCharacter() as SimpleCharacter },
            info = res?.info?.toinfo()
        )


    }

    override suspend fun getCharacterById(id: Int): DetailedCharacter {
        TODO("Not yet implemented")
    }
}


