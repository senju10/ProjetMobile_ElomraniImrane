package com.example.myapp.screens.signup

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.myapp.R
import com.example.myapp.components.AppButton
import com.example.myapp.navigation.Screen
import com.example.myapp.components.InputField
import com.example.myapp.components.SectionTitle

@Composable
fun SignUpScreen(navController: NavController) {

    val name = remember { mutableStateOf("") }
    val email = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.Center
    ) {

        SectionTitle(
            text = stringResource(R.string.signup_title),
            modifier = Modifier.padding(bottom = 24.dp)
        )

        InputField(
            value = name,
            label = stringResource(R.string.name),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
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
            text = stringResource(R.string.signup_button),
            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp)
        ) {
            navController.navigate(Screen.Login.route)
        }

        Spacer(modifier = Modifier.height(12.dp))

        Row {
            Text(text = stringResource(R.string.already_account))
            Spacer(modifier = Modifier.width(6.dp))

            Text(
                text = stringResource(R.string.login_button),
                fontWeight = FontWeight.Bold,
                modifier = Modifier.clickable {
                    navController.navigate(Screen.Login.route)
                }
            )
        }

    }

}
