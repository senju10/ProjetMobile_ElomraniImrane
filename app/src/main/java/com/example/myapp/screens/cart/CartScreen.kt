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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.myapp.navigation.Screen
import com.example.myapp.R
import com.example.myapp.components.SectionTitle
import com.example.myapp.components.AppButton


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

        SectionTitle(
            text = stringResource(R.string.cart_title),
            modifier = Modifier.padding(bottom = 20.dp)
        )

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier.weight(1f)
        ) {
            items(fakeCartItems) { item ->
                CartItemCard(item)
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "${stringResource(R.string.cart_total)}: $total $",
            modifier = Modifier.padding(bottom = 20.dp)
        )

        AppButton(
            text = stringResource(R.string.checkout),
            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp)
        ) {
            navController.navigate(Screen.Confirmation.route)
        }
    }
}

@Composable
fun CartItemCard(item: CartItem) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = item.name)
            Spacer(modifier = Modifier.height(6.dp))
            Text(text = "${item.price} $")
        }
    }
}