package com.saj.cryptoapplication.domain.repository

import com.saj.cryptoapplication.data.remote.dto.CoinDetailDto
import com.saj.cryptoapplication.data.remote.dto.CoinDto

interface CoinRepository {
    suspend fun getCoins() : List<CoinDto>
    suspend fun getCoinById(coinId: String) : CoinDetailDto
}