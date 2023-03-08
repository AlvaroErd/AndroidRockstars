package com.mango.androidrockstars.data.datasource.features.topratedtvlist.remote.mapper

import com.mango.androidrockstars.data.datasource.features.topratedtvlist.model.ApiDetailResponse
import com.mango.androidrockstars.data.datasource.features.topratedtvlist.model.ApiListResponse
import com.mango.androidrockstars.domain.model.topratedtvlist.TopRatedTvPage
import com.mango.androidrockstars.domain.model.topratedtvlist.TopRatedTvProperties


fun topRatedTvListResponseMapper(apiList: ApiListResponse): TopRatedTvPage {
    return TopRatedTvPage(
        page = apiList.page,
        results = apiList.results.map { topRatedTvListResultsResponseMapper(it) },
        totalPages = apiList.totalPages,
        totalResults = apiList.totalResults
    )
}

fun topRatedTvListResultsResponseMapper(apiDetail: ApiDetailResponse): TopRatedTvProperties {
    return TopRatedTvProperties(
        name = apiDetail.name,
        id = apiDetail.id,
        posterPathList = "https://image.tmdb.org/t/p/w500${apiDetail.posterPath}",
        voteAverage = apiDetail.voteAverage,
        voteCount = apiDetail.voteCount
    )
}