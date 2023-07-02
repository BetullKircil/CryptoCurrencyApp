package com.betulkircil.crypto_app_clean_arthitecture.presentation.views.CoinDetailScreen

import com.betulkircil.crypto_app_clean_arthitecture.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coinById: List<CoinDetail>? = null,
    val error: String = ""
)