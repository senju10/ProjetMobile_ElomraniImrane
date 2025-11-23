package com.example.myapp.screens.error

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
fun ErrorScreen(navController: NavController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(text = "⚠ Something went wrong", modifier = Modifier.padding(bottom = 8.dp))

        Text(
            text = "Please try again.",
            modifier = Modifier.padding(bottom = 30.dp)
        )

        Button(
            onClick = { navController.navigate(Screen.Shop.route) },
            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp)
        ) {
            Text(text = "Try Again")
        }
    }
}
