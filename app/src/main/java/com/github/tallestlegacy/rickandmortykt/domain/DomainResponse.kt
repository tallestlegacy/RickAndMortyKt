package com.github.tallestlegacy.rickandmortykt.domain


data class DomainResponse<T>(
    var info: PaginationInfo?,
    var results: List<T>?,
)

data class PaginationInfo(
    var count: Int?,
    var pages: Int?,
    var next: String?,
    var prev: String?,
)