package com.example.myapp.screens.confirmation

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.myapp.navigation.Screen

@Composable
fun ConfirmationScreen(navController: NavController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(text = "✔ Order Confirmed!", modifier = Modifier.padding(bottom = 12.dp))

        Text(
            text = "Your order has been placed successfully.",
            modifier = Modifier.padding(bottom = 30.dp)
        )

        Button(
            onClick = { navController.navigate(Screen.Shop.route) },
            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp)
        ) {
            Text(text = "Back to Home")
        }
    }
}