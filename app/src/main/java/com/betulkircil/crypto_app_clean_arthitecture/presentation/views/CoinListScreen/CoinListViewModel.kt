package com.betulkircil.crypto_app_clean_arthitecture.presentation.views.CoinListScreen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.betulkircil.crypto_app_clean_arthitecture.domain.useCase.getCoinList.getCoinsUseCase
import com.betulkircil.crypto_app_clean_arthitecture.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinListViewModel @Inject constructor(
    private val getCoinsUseCase: getCoinsUseCase
) : ViewModel(){
    private val _state = mutableStateOf(CoinListState())
    val state : State<CoinListState> = _state

    init {
        getCoins()
    }
    private  fun getCoins(){
        //invoke fonksiyon olarak tanımladigimiz icin burada use case'i bir method olarak tanımlayabiliyoruz
        getCoinsUseCase().onEach {
            when(it){
                is Resource.Loading -> {
                    _state.value = CoinListState(isLoading = true)
                }
                is Resource.Success -> {
                    _state.value = CoinListState(coins = it.data ?: emptyList())
                }
                is Resource.Error -> {
                    _state.value = CoinListState(error = it.message ?: "Unexpected error")
                }
            }
        }.launchIn(viewModelScope)
    }

}