package com.saj.cryptoapplication.domain.use_case.get_coins

import com.saj.cryptoapplication.common.Resource
import com.saj.cryptoapplication.data.remote.dto.toCoin
import com.saj.cryptoapplication.domain.model.Coin
import com.saj.cryptoapplication.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading())
            val coins = repository.getCoins().map { it.toCoin() }
            emit(Resource.Success(coins))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occured"))
        } catch (e: IOException) {
            emit (Resource.Error("Couldn't connect to the server"))
        }
    }
}