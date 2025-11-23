package com.example.myapp.screens.shop

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.myapp.components.ProductCard
import com.example.myapp.navigation.Screen
import com.example.myapp.components.Product
import com.example.myapp.components.SectionTitle
import com.example.myapp.R



// Fake data temporaire
data class Product(
    val id: String,
    val name: String,
    val price: String
)

val fakeProducts = listOf(
    Product("1", "Snowboard Jacket", 99.0),
    Product("2", "Ski Pants", 79.0),
    Product("3", "Winter Gloves", 25.0)
)

@Composable
fun ShopScreen(navController: NavController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {

        SectionTitle(
            text = stringResource(R.string.shop_title),
            modifier = Modifier.padding(bottom = 20.dp)
        )

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier.fillMaxSize()
        ) {
            items(fakeProducts) { product ->
                ProductCard(
                    product = product,
                    onClick = {
                        navController.navigate(Screen.Detail.createRoute(product.id))
                    }
                )
            }
        }
    }
}