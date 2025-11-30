package com.example.myapp.screens.welcome

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.myapp.R
import com.example.myapp.components.AppButton
import com.example.myapp.navigation.Screen


@Composable
fun WelcomeScreen(navController: NavController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {

        Spacer(modifier = Modifier.height(10.dp))

        Image(
            painter = painterResource(id = R.drawable.snowboard),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(380.dp)
        )

        Column(horizontalAlignment = Alignment.CenterHorizontally) {

            Text(
                text = stringResource(id = R.string.welcome_title),
                style = MaterialTheme.typography.titleMedium
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = stringResource(id = R.string.welcome_desc),
                style = MaterialTheme.typography.bodyMedium
            )
        }

        AppButton(
            text = stringResource(id = R.string.get_started),
            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp)
        ) {
            navController.navigate(Screen.Login.route)
        }

        Spacer(modifier = Modifier.height(20.dp))
    }
}