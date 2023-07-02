package com.betulkircil.crypto_app_clean_arthitecture.presentation.views.CoinListScreen

import com.betulkircil.crypto_app_clean_arthitecture.domain.model.Coin

data class CoinListState(
    val isLoading : Boolean = false,
    val coins : List<Coin> = emptyList(),
    val error : String = ""
)