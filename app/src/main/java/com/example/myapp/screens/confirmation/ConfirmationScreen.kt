package com.example.myapp.screens.confirmation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import com.example.myapp.components.SectionTitle
import com.example.myapp.components.AppButton
import com.example.myapp.R


@Composable
fun ConfirmationScreen(navController: NavController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        SectionTitle(
            text = stringResource(R.string.order_confirmed),
            modifier = Modifier.padding(bottom = 12.dp)
        )

        Text(
            text = stringResource(R.string.order_success),
            modifier = Modifier.padding(bottom = 30.dp)
        )

        Image(
            painter = painterResource(id = R.drawable.checktrue),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(380.dp)
        )

        AppButton(
            text = stringResource(R.string.back_home),
            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp)
        ) {
            navController.navigate(Screen.Shop.route)
        }
    }
}