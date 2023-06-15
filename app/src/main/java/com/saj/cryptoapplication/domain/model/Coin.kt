package com.saj.cryptoapplication.domain.model

data class Coin(
    val id: String,
    val isActive: Boolean,
 //   val is_new: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
   // val type: String
)