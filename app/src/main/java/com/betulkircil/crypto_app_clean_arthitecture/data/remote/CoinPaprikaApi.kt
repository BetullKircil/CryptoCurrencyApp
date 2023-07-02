package com.betulkircil.crypto_app_clean_arthitecture.data.remote

import com.betulkircil.crypto_app_clean_arthitecture.data.remote.dto.CoinDetailDto
import com.betulkircil.crypto_app_clean_arthitecture.data.remote.dto.CoinDto
import com.betulkircil.crypto_app_clean_arthitecture.utils.Constants
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinPaprikaApi {
    @GET(Constants.END_POINT)
    suspend fun getCoin() : List<CoinDto>

    @GET("v1/coins/{coinId}")
    suspend fun getCoinById(@Path("coinId") coinId : String) : CoinDetailDto
}