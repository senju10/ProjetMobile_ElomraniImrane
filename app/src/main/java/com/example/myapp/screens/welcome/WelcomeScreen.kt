package com.example.myapp.screens.welcome

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.myapp.navigation.Screen
import com.example.myapp.R
import com.example.myapp.components.AppButton

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
            Text(stringResource(id = R.string.welcome_title))
            Spacer(modifier = Modifier.height(10.dp))
            Text(stringResource(id = R.string.welcome_desc))
        }

        // BUTTON
        AppButton(
            text = stringResource(R.string.get_started),
            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp)
        ) {
            navController.navigate(Screen.Login.route)
        }
    }
}

