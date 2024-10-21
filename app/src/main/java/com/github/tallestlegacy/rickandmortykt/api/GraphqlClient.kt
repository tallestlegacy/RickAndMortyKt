package com.github.tallestlegacy.rickandmortykt.api

import com.apollographql.apollo.ApolloClient

const val BASE_URL = "https://rickandmortyapi.com/graphql"

val apolloClient = ApolloClient.Builder()
    .serverUrl(BASE_URL)
    .build()
