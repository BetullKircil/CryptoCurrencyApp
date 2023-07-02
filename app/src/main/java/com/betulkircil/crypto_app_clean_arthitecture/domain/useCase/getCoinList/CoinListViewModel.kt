package com.betulkircil.crypto_app_clean_arthitecture.domain.useCase.getCoinList

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CoinListViewModel @Inject constructor(
    private val getCoinsUseCase: getCoinsUseCase
) : ViewModel(){

}