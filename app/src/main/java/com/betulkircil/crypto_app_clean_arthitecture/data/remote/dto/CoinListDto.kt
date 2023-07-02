package com.betulkircil.crypto_app_clean_arthitecture.data.remote.dto

import com.betulkircil.crypto_app_clean_arthitecture.domain.model.Coin
import com.google.gson.annotations.SerializedName

data class CoinDto(
    val id: String,
    @SerializedName("is_active") //that is the  name in the api
    val isActive: Boolean,
    @SerializedName("is_new")
    val isNew: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
    val type: String
)

fun CoinDto.toCoin() : Coin {
    return Coin(
        id = id,
        isActive = isActive,
        name = name,
        rank = rank,
        symbol = symbol
    )
}

//that's the extension function that will convert dto to the model we'll use