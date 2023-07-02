package com.betulkircil.crypto_app_clean_arthitecture.domain.model

import com.betulkircil.crypto_app_clean_arthitecture.data.remote.dto.TeamMember
import com.google.gson.annotations.SerializedName

data class CoinDetail(
    val description: String,
    val id: String,
    @SerializedName("is_active")
    val isActive: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
    val tags: List<String>,
    val team: List<TeamMember>,
)