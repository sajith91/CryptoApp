package com.saj.cryptoapplication.presentation.coin_detail


import com.saj.cryptoapplication.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coinDetail: CoinDetail? = null,
    val error: String = ""
)
