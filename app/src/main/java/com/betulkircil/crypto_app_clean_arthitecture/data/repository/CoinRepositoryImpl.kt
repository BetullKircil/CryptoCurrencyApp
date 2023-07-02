package com.betulkircil.crypto_app_clean_arthitecture.data.repository

import com.betulkircil.crypto_app_clean_arthitecture.data.remote.CoinPaprikaApi
import com.betulkircil.crypto_app_clean_arthitecture.data.remote.dto.CoinDetailDto
import com.betulkircil.crypto_app_clean_arthitecture.data.remote.dto.CoinDto
import com.betulkircil.crypto_app_clean_arthitecture.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaApi  //dagger hilt kullanarak repositoryImpl'nin icine api'mizi inject ettik
) : CoinRepository{
    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoin()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return api.getCoinById(coinId)
    }
}