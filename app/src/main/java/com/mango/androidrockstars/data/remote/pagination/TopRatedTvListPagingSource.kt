package com.mango.androidrockstars.data.remote.pagination

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.mango.androidrockstars.BuildConfig
import com.mango.androidrockstars.data.datasource.features.topratedtvlist.remote.mapper.topRatedTvListResultsResponseMapper
import com.mango.androidrockstars.data.repository.TopRatedTvRepository
import com.mango.androidrockstars.domain.model.topratedtvlist.TopRatedTvProperties
import retrofit2.HttpException
import javax.inject.Inject

class TopRatedTvListPagingSource @Inject constructor(
    private val repositoryPaging: TopRatedTvRepository
) : PagingSource<Int, TopRatedTvProperties>() {
    override fun getRefreshKey(state: PagingState<Int, TopRatedTvProperties>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, TopRatedTvProperties> {
        return try {
            val page = params.key ?: 1
            val topRatedTvList = repositoryPaging.getAllTvShows(
                page = page,
                apiKey = BuildConfig.API_KEY,
                language = "en-US"
            )

            LoadResult.Page(
                data = topRatedTvList.results.map {
                    topRatedTvListResultsResponseMapper(it)
                },
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