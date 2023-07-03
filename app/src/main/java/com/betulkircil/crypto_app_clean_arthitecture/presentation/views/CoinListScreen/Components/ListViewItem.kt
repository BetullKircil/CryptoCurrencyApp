package com.betulkircil.crypto_app_clean_arthitecture.presentation.views.CoinListScreen.Components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.betulkircil.crypto_app_clean_arthitecture.domain.model.Coin
import org.w3c.dom.Text

@Composable
fun ListViewItem(
    coin : Coin,
    onItemClick : (Coin) -> Unit
) {
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                onItemClick(coin)
            }
            .padding(20.dp),
        horizontalArrangement = Arrangement.SpaceBetween
            ){
            CoinText(coin = coin)

    }
    
}

@Composable
fun CoinText(coin : Coin) {
    return Text(text = "${coin.rank}. ${coin.name} ${coin.symbol}", style = MaterialTheme.typography.bodyMedium, overflow = TextOverflow.Ellipsis)
}

@Composable
fun ActivationText(coin : Coin) {
    return Text(text = if (coin.isActive) "Active" else "Inactive",
        color = if(coin.isActive) Color.Green else Color.Red,
        fontStyle = FontStyle.Italic,
        textAlign = TextAlign.End,
        style = MaterialTheme.typography.bodyMedium
    )
    
}