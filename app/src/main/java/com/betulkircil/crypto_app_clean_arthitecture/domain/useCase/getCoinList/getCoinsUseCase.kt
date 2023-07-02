package com.betulkircil.crypto_app_clean_arthitecture.domain.useCase.getCoinList

import com.betulkircil.crypto_app_clean_arthitecture.data.remote.dto.toCoin
import com.betulkircil.crypto_app_clean_arthitecture.domain.model.Coin
import com.betulkircil.crypto_app_clean_arthitecture.domain.repository.CoinRepository
import com.betulkircil.crypto_app_clean_arthitecture.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class getCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke() : Flow<Resource<List<Coin>>> = flow{
        try {
            emit(Resource.Loading())
            val coins = repository.getCoins().map {
                it.toCoin()
            }
            emit(Resource.Success(coins))
        }
        catch (e : Exception){
            emit(Resource.Error(e.localizedMessage?: "Unexpected error"))
        }
        catch (e : IOException){
            emit(Resource.Error("Couldn't reach the server. Check your internet connection"))
        }
    }
}