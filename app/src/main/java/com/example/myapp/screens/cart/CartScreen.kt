package com.example.myapp.screens.cart

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.myapp.navigation.Screen

// Fake data
data class CartItem(
    val id: String,
    val name: String,
    val price: Double
)

val fakeCartItems = listOf(
    CartItem("1", "Snowboard Jacket", 99.0),
    CartItem("2", "Winter Gloves", 25.0)
)

@Composable
fun CartScreen(navController: NavController) {

    val total = fakeCartItems.sumOf { it.price }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {

        Text(text = "Your Cart", modifier = Modifier.padding(bottom = 20.dp))

        LazyColumn(verticalArrangement = Arrangement.spacedBy(12.dp)) {
            items(fakeCartItems) { item ->
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    elevation = CardDefaults.cardElevation(4.dp)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(text = item.name)
                        Spacer(Modifier.height(6.dp))
                        Text(text = "${item.price} $")
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(25.dp))

        Text(text = "Total: $total $", modifier = Modifier.padding(bottom = 20.dp))

        Button(
            onClick = { navController.navigate(Screen.Confirmation.route) },
            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp)
        ) {
            Text("Checkout")
        }
    }
}