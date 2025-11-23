package com.example.myapp.screens.details

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.myapp.navigation.Screen
import com.example.myapp.R
import com.example.myapp.components.SectionTitle
import com.example.myapp.components.AppButton


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

        SectionTitle(
            text = stringResource(R.string.details_title),
            modifier = Modifier.padding(bottom = 20.dp)
        )

        Text(
            text = "ID: $productId",
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))

        AppButton(
            text = stringResource(R.string.add_to_cart),
            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp)
        ) {
            navController.navigate(Screen.Cart.route)
        }
    }
}