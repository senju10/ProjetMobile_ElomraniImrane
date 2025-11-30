package com.example.myapp.screens.cart

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.myapp.navigation.Screen
import com.example.myapp.R
import com.example.myapp.components.SectionTitle
import com.example.myapp.components.AppButton
import com.example.myapp.components.BottomNavigationBar
import com.example.myapp.screens.cart.CircleButton


// Fake data
data class CartItem(
    val name: String,
    val size: String,
    val price: Double,
    val imageRes: Int? = null,
    val quantity: Int = 1
)


val cartItems = listOf(
    CartItem("Snowboard Jacket", "Size M", 120.0),
    CartItem("Ski Pants", "Size S", 80.0),
    CartItem("Snowboard Boots", "Size 9", 100.0, R.drawable.boots),
    CartItem("Ski Gloves", "Size M", 50.0)
)

@Composable
fun CartScreen(navController: NavController) {

    Scaffold(
        topBar = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Cart",
                    style = MaterialTheme.typography.titleLarge
                )
            }
        },
        bottomBar = { BottomNavigationBar() }
    ) { padding ->

        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
        ) {

            // Cart Items
            cartItems.forEach { item ->
                CartItemRow(item)
            }

            Spacer(modifier = Modifier.height(32.dp))

            // Subtotal
            PriceRow("Subtotal", "$350")
            PriceRow("Shipping", "$10")
            PriceRow("Total", "$360", bold = true)

            Spacer(modifier = Modifier.height(24.dp))

            // Checkout Button
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .height(55.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(Color(0xFF2196F3)),
                contentAlignment = Alignment.Center
            ) {
                AppButton(
                    text = stringResource(R.string.checkout),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(55.dp)
                ) {
                    navController.navigate(Screen.Confirmation.route)
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .height(55.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(Color(0xFF2196F3)),
                contentAlignment = Alignment.Center
            ) {
                AppButton(
                    text = stringResource(R.string.false_checkout),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(55.dp)
                ) {
                    navController.navigate(Screen.Error.route)
                }
            }

        }
    }
}


@Composable
fun CartItemRow(item: CartItem) {

    var quantity by remember { mutableStateOf(item.quantity) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 12.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        // Left side: name, size, maybe image
        Row {

            if (item.imageRes != null) {
                Image(
                    painter = painterResource(item.imageRes),
                    contentDescription = null,
                    modifier = Modifier
                        .size(55.dp)
                        .clip(RoundedCornerShape(8.dp)),
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.width(12.dp))
            }

            Column {
                Text(item.name, style = MaterialTheme.typography.bodyLarge)
                Text(item.size, color = Color.Gray)
            }
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {

            CircleButton("-") {
                if (quantity > 1) quantity--
            }

            Text(quantity.toString(), style = MaterialTheme.typography.bodyLarge)

            CircleButton("+") {
                quantity++
            }
        }
    }
}

@Composable
fun CircleButton(symbol: String, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .size(32.dp)
            .clip(CircleShape)
            .background(Color(0xFFF3F3F3))
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Text(symbol, fontSize = 20.sp, fontWeight = FontWeight.Bold)
    }
}

@Composable
fun PriceRow(label: String, amount: String, bold: Boolean = false) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 4.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = label,
            style = if (bold) MaterialTheme.typography.bodyLarge else MaterialTheme.typography.bodyMedium
        )
        Text(
            text = amount,
            style = if (bold) MaterialTheme.typography.bodyLarge else MaterialTheme.typography.bodyMedium
        )
    }
}
