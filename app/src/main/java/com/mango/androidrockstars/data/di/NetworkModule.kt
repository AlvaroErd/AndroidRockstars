package com.mango.androidrockstars.data.di

import com.mango.androidrockstars.BuildConfig
import com.mango.androidrockstars.data.remote.ImdbApiService
import com.mango.androidrockstars.data.repository.TopRatedTvDetailRepositoryImpl
import com.mango.androidrockstars.data.repository.TopRatedTvListRepositoryImpl
import com.mango.androidrockstars.data.source.RemoteTopRatedTvDetailDataSource
import com.mango.androidrockstars.data.source.RemoteTopRatedTvListDataSource
import com.mango.androidrockstars.data.source.TopRatedTvDetailDataSource
import com.mango.androidrockstars.data.source.TopRatedTvListDataSource
import com.mango.androidrockstars.domain.repository.TopRatedTvDetailRepository
import com.mango.androidrockstars.domain.repository.TopRatedTvListRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideTopRatedTvApiClient(retrofit: Retrofit): ImdbApiService {
        return retrofit.create(ImdbApiService::class.java)
    }

    @Provides
    fun provideTopRatedTvDataStore(api: ImdbApiService): TopRatedTvListDataSource {
        return RemoteTopRatedTvListDataSource(api)
    }

    @Provides
    fun provideTopRatedTvRepository(dataStore: TopRatedTvListDataSource): TopRatedTvListRepository {
        return TopRatedTvListRepositoryImpl(dataStore)
    }

    @Provides
    fun provideTopRatedTvDetailDataStore(api: ImdbApiService): TopRatedTvDetailDataSource {
        return RemoteTopRatedTvDetailDataSource(api)
    }

    @Provides
    fun provideTopRatedTvDetailRepository(dataStore: TopRatedTvDetailDataSource): TopRatedTvDetailRepository {
        return TopRatedTvDetailRepositoryImpl(dataStore)
    }
}