package com.saj.cryptoapplication.domain.model

import com.saj.cryptoapplication.data.remote.dto.Tag
import com.saj.cryptoapplication.data.remote.dto.Team

data class CoinDetail(
    val id: String,
    val name: String,
    val description: String,
    val symbol: String,
    val rank: Int,
    val is_active: Boolean,
    val tags: List<String>,
    val team: List<Team>
)
