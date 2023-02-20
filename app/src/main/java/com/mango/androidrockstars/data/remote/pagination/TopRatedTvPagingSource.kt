package com.mango.androidrockstars.data.remote.pagination

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.mango.androidrockstars.data.datasource.features.topratedtvlist.model.ApiDetailResponse
import com.mango.androidrockstars.data.remote.ImdbApiService

class TopRatedTvPagingSource(
    private val topRatedTvApiService: ImdbApiService,
) : PagingSource<Int, ApiDetailResponse>() {
    override fun getRefreshKey(state: PagingState<Int, ApiDetailResponse>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ApiDetailResponse> {
        return try {
            val page = params.key ?: 1
            val response =
                topRatedTvApiService.getTopRatedTv(page = page, apiKey = "", language = "")

            LoadResult.Page(
                data = response.results,
                prevKey = if (page == 1) null else page.minus(1),
                nextKey = if (response.results.isEmpty()) null else page.plus(1),
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}