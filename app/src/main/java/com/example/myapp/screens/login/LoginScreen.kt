package com.example.myapp.screens.login

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.myapp.R
import com.example.myapp.components.AppButton
import com.example.myapp.navigation.Screen
import com.example.myapp.components.InputField
import com.example.myapp.components.SectionTitle


@Composable
fun LoginScreen(navController: NavController) {

    val email = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.Center
    ) {

        SectionTitle(
            text = stringResource(R.string.login_title),
            modifier = Modifier.padding(bottom = 24.dp)
        )

        InputField(
            value = email,
            label = stringResource(R.string.email),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )

        InputField(
            value = password,
            label = stringResource(R.string.password),
            isPassword = true,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 24.dp)
        )

        AppButton(
            text = stringResource(R.string.login_button),
            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp)
        ) {
            navController.navigate(Screen.Shop.route)
        }
    }
}