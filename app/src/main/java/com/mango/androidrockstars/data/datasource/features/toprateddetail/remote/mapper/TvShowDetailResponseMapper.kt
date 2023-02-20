package com.mango.androidrockstars.data.datasource.features.toprateddetail.remote.mapper

import com.mango.androidrockstars.data.datasource.features.toprateddetail.model.ApiDetailResponse
import com.mango.androidrockstars.domain.model.TvShowDetail

private fun tvShowDetailResponseMapper(apiDetail: ApiDetailResponse): TvShowDetail {
    return TvShowDetail(
        id = apiDetail.tv_Id,
        posterPath = "https://image.tmdb.org/t/p/w500${apiDetail.posterPath}",
        name = apiDetail.name,
        voteCount = apiDetail.voteCount,
        voteAverage = apiDetail.voteAverage,
        first_air_date = apiDetail.release_date,
        overview = apiDetail.overview,
        original_language = apiDetail.original_language,
    )
}