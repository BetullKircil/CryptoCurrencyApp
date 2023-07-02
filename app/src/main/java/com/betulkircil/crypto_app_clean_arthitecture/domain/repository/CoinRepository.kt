package com.betulkircil.crypto_app_clean_arthitecture.domain.repository

import com.betulkircil.crypto_app_clean_arthitecture.data.remote.dto.CoinDetailDto
import com.betulkircil.crypto_app_clean_arthitecture.data.remote.dto.CoinDto

interface CoinRepository {
    //repository use case'e inject etmek icin interface olusturulur
    suspend fun getCoins() : List<CoinDto>

    suspend fun getCoinById(coinId : String) : CoinDetailDto
}