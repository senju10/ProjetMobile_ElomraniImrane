package com.example.myapp.screens.welcome

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.myapp.navigation.Screen
import com.example.myapp.R

@Composable
fun WelcomeScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {

        // IMAGE
        Image(
            painter = painterResource(id = R.drawable.snowboard),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(320.dp)
        )

        // TEXTS (temporaires)
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "Welcome to Winter Sports")
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = "Discover the best winter gear and clothing")
        }

        // BUTTON
        Button(
            onClick = { navController.navigate(Screen.Login.route) },
            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp)
        ) {
            Text(text = "Get Started")
        }
    }
}

