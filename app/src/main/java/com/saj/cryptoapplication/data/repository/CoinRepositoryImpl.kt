package com.saj.cryptoapplication.data.repository

import com.saj.cryptoapplication.data.remote.CoinPapricaAPI
import com.saj.cryptoapplication.data.remote.dto.CoinDetailDto
import com.saj.cryptoapplication.data.remote.dto.CoinDto
import com.saj.cryptoapplication.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl  @Inject constructor(
    private val api : CoinPapricaAPI
): CoinRepository{
    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
       return api.getCoinById(coinId)
    }
}