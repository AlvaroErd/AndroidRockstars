package com.mango.androidrockstars.data.remote.pagination

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.mango.androidrockstars.BuildConfig
import com.mango.androidrockstars.data.datasource.features.topratedtvlist.model.ApiDetailResponse
import com.mango.androidrockstars.data.repository.TopRatedTvRepository
import retrofit2.HttpException
import javax.inject.Inject

class TopRatedTvListPagingSource @Inject constructor(
    private val repositoryPaging: TopRatedTvRepository
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
            val topRatedTvList = repositoryPaging.getAllTvShows(
                page = page,
                apiKey = BuildConfig.API_KEY,
                language = "en-US"
            )

            LoadResult.Page(
                data = topRatedTvList.results,
                prevKey = if (page == 1) null else page.minus(1),
                nextKey = if (topRatedTvList.results.isEmpty()) null else topRatedTvList.page.plus(1)
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        } catch (httpE: HttpException) {
            LoadResult.Error(httpE)
        }
    }

}