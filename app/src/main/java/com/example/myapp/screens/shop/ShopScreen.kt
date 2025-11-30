package com.example.myapp.screens.shop

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.myapp.components.ProductCard
import com.example.myapp.navigation.Screen
import com.example.myapp.components.Product
import com.example.myapp.R
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import com.example.myapp.components.BottomNavigationBar

val products = listOf(
    Product(1, "Adidas Snow Pants", 129.99, R.drawable.snowpants),
    Product(3, "Puma Insulated Jacket", 99.99, R.drawable.insulatedjacket, isClickable = true),
    Product(2, "Nike Crew", 109.99, null),
    Product(4, "Adidas Boots", 119.99, R.drawable.boots)
)
@Composable
fun ShopScreen(navController: NavController) {
    Scaffold (
        topBar = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 24.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = stringResource(R.string.shop_title),
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
            CategoryRowSimple()
            LazyColumn(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxSize()
            ) {
                items(products) { product ->
                    ProductCard(
                        product = product,
                        modifier = Modifier.clickable(enabled = product.isClickable) {
                            navController.navigate(Screen.Detail.route)
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun CategoryRowSimple() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 6.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {

        // ALL — mis en avant
        Box(
            modifier = Modifier
                .background(
                    color = Color(0xFFECECEC),
                    shape = RoundedCornerShape(12.dp)
                )
                .padding(horizontal = 16.dp, vertical = 4.dp)
        ) {
            Text(
                text = "All",
                style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold)
            )
        }

        // Men
        Text(
            text = "Men",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(vertical = 4.dp)
        )

        // Women
        Text(
            text = "Women",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(vertical = 4.dp)
        )

        // Kids
        Text(
            text = "Kids",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(vertical = 4.dp)
        )
    }
}