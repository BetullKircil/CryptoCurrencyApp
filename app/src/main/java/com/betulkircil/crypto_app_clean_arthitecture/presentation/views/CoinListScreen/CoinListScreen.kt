package com.betulkircil.crypto_app_clean_arthitecture.presentation.views.CoinListScreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.betulkircil.crypto_app_clean_arthitecture.presentation.Screen
import com.betulkircil.crypto_app_clean_arthitecture.presentation.views.CoinListScreen.Components.ListViewItem

@Composable
fun CoinListScreen(
    navController: NavController,
    viewModel: CoinListViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    Box(modifier = androidx.compose.ui.Modifier.fillMaxSize()){
        LazyColumn(modifier = androidx.compose.ui.Modifier.fillMaxSize()){
            items(state.coins){coin ->
                ListViewItem(
                    coin = coin,
                onItemClick = {
                    navController.navigate(Screen.CoinDetailScreen.route + "${coin.id}")
                }
                )
            }
        }

        if(state.error.isNotEmpty()){
            Text(text = state.error,
            color = MaterialTheme.colorScheme.error,
            textAlign = TextAlign.Center, modifier = Modifier
                    .padding(20.dp)
                    .align(Alignment.Center))
        }
        if(state.isLoading){
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }
}