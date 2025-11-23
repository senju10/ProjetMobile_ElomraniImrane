package com.example.myapp.screens.shop

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.myapp.navigation.Screen

// Fake data temporaire
data class Product(
    val id: String,
    val name: String,
    val price: String
)

val sampleProducts = listOf(
    Product("1", "Snowboard Jacket", "$99"),
    Product("2", "Ski Gloves", "$25"),
    Product("3", "Winter Boots", "$79")
)

@Composable
fun ShopScreen(navController: NavController) {

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {

        Text(text = "Shop", modifier = Modifier.padding(bottom = 20.dp))

        // Liste de produits
        LazyColumn(verticalArrangement = Arrangement.spacedBy(12.dp)) {
            items(sampleProducts) { product ->

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            navController.navigate(
                                Screen.Detail.createRoute(product.id)
                            )
                        },
                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(text = product.name)
                        Spacer(Modifier.height(6.dp))
                        Text(text = product.price)
                    }
                }

            }
        }

    }
}