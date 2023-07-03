package com.betulkircil.crypto_app_clean_arthitecture.presentation

sealed class Screen(val route : String){
    object CoinListScreen : Screen("coinList")
    object CoinDetailScreen :Screen("coinDetail")
}
