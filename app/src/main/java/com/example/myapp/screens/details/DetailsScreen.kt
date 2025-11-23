package com.example.myapp.screens.details

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.myapp.navigation.Screen

@Composable
fun DetailScreen(
    navController: NavController,
    productId: String?
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {

        Text(text = "Product Details", modifier = Modifier.padding(bottom = 20.dp))

        Text(text = "Product ID: $productId")

        Spacer(modifier = Modifier.height(30.dp))

        Button(
            onClick = { navController.navigate(Screen.Cart.route) },
            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp)
        ) {
            Text(text = "Add to Cart")
        }
    }
}