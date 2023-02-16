package com.mango.androidrockstars.data.model.features.topratedtvlist.repository

import com.mango.androidrockstars.data.remote.ImdbApiService

class NTopRatedTvRepository(
    private val imdbApiService: ImdbApiService
) {

//    fun getNews() = Pager(
//        config = PagingConfig(
//            pageSize = 20,
//        ),
//        pagingSourceFactory = {
//            NewsPagingSource(newsApiService)
//        }
//    ).flow
}

// https://proandroiddev.com/pagination-in-jetpack-compose-with-and-without-paging-3-e45473a352f4