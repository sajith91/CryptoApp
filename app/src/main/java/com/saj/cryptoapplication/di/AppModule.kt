package com.saj.cryptoapplication.di


import com.saj.cryptoapplication.common.Constants
import com.saj.cryptoapplication.data.remote.CoinPapricaAPI
import com.saj.cryptoapplication.data.repository.CoinRepositoryImpl
import com.saj.cryptoapplication.domain.repository.CoinRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun providePapricaApi() : CoinPapricaAPI{
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinPapricaAPI::class.java)
    }

    @Provides
    @Singleton
    fun provideCoinRepository(api: CoinPapricaAPI) :CoinRepository{
        return CoinRepositoryImpl(api)
    }
}