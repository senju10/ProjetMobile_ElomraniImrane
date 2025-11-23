package com.example.myapp.screens.login

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.myapp.navigation.Screen

@Composable
fun LoginScreen(navController: NavController) {

    // Champs temporaires (UI seulement pour l'instant)
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(text = "Login", modifier = Modifier.padding(bottom = 20.dp))

        // Champ Email
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Champ Password
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(25.dp))

        // Bouton Login
        Button(
            onClick = { navController.navigate(Screen.Shop.route) },
            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp)
        ) {
            Text(text = "Login")
        }

        Spacer(modifier = Modifier.height(12.dp))

        // Aller vers SignUp
        Text(
            text = "Don't have an account? Sign Up",
            modifier = Modifier.clickable {
                navController.navigate(Screen.SignUp.route)
            }
        )
    }
}