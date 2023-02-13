package com.mango.androidrockstars.data.model.features.topratedtvlist

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.mango.androidrockstars.data.remote.ImdbApiService

class TopRatedTvPagingSource(
    private val topRatedTvApiService: ImdbApiService,
) : PagingSource<Int, ApiResult>() {
    override fun getRefreshKey(state: PagingState<Int, ApiResult>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ApiResult> {
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