package com.betulkircil.crypto_app_clean_arthitecture.presentation.views.CoinDetailScreen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.betulkircil.crypto_app_clean_arthitecture.domain.useCase.getCoinDetail.getCoinDetailUseCase
import com.betulkircil.crypto_app_clean_arthitecture.utils.Constants
import com.betulkircil.crypto_app_clean_arthitecture.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinDetailViewModel @Inject constructor(
    private val getCoinDetailUseCase: getCoinDetailUseCase,
    private val savedStateHandle: SavedStateHandle
) : ViewModel(){
    private val _state = mutableStateOf(CoinDetailState())
    val state : State<CoinDetailState> = _state

    init {
        savedStateHandle.get<String>(Constants.PARAM_COIN_ID)?.let {
            coinId ->
            getCoinDetail(coinId)
        }
    }
    private  fun getCoinDetail(coinId : String){
        //invoke fonksiyon olarak tanımladigimiz icin burada use case'i bir method olarak tanımlayabiliyoruz
        getCoinDetailUseCase(coinId).onEach {
            when(it){
                is Resource.Loading -> {
                    _state.value = CoinDetailState(isLoading = true)
                }
                is Resource.Success -> {
                    _state.value = CoinDetailState(coinById = it.data)
                }
                is Resource.Error -> {
                    _state.value = CoinDetailState(error = it.message ?: "Unexpected error")
                }
            }
        }.launchIn(viewModelScope)
    }

}