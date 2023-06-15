package com.saj.cryptoapplication.domain.use_case.get_coin

import com.saj.cryptoapplication.common.Resource
import com.saj.cryptoapplication.data.remote.dto.CoinDetailDto
import com.saj.cryptoapplication.data.remote.dto.toCoinDetail
import com.saj.cryptoapplication.domain.model.CoinDetail
import com.saj.cryptoapplication.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(coinId:String): Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading())
            val coin = repository.getCoinById(coinId = coinId).toCoinDetail()
            emit(Resource.Success(coin))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occured"))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't connect to the server"))
        }
    }
}