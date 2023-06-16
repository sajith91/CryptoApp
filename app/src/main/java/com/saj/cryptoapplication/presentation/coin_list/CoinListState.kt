package com.saj.cryptoapplication.presentation.coin_list

import com.saj.cryptoapplication.domain.model.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val coinList: List<Coin> = emptyList(),
    val error: String = ""
)
