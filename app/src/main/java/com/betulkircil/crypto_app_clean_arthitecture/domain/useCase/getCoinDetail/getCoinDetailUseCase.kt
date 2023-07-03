package com.betulkircil.crypto_app_clean_arthitecture.domain.useCase.getCoinDetail

import com.betulkircil.crypto_app_clean_arthitecture.data.remote.dto.toCoinDetail
import com.betulkircil.crypto_app_clean_arthitecture.domain.model.CoinDetail
import com.betulkircil.crypto_app_clean_arthitecture.domain.repository.CoinRepository
import com.betulkircil.crypto_app_clean_arthitecture.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class getCoinDetailUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(coinId : String) : Flow<Resource<CoinDetail>> = flow{
        try {
            emit(Resource.Loading())
            val coin = repository.getCoinById(coinId).toCoinDetail()
            emit(Resource.Success<CoinDetail>(coin))
        }
        catch (e : Exception){
            emit(Resource.Error(e.localizedMessage?: "Unexpected error"))
        }
        catch (e : IOException){
            emit(Resource.Error("Couldn't reach the server. Check your internet connection"))
        }
    }
}