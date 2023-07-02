package com.betulkircil.crypto_app_clean_arthitecture.domain.model

import com.google.gson.annotations.SerializedName

data class Coin(
    val id: String,
    val isActive: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
)

//that is the model data class we'll use
