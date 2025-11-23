package com.example.myapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun AppNavGraph(navController: NavHostController) {

    NavHost(
        navController = navController,
        startDestination = Screen.Welcome.route
    ) {

        composable(Screen.Welcome.route) {
            com.example.myapp.screens.welcome.WelcomeScreen(navController)
        }

        composable(Screen.Login.route) {
            com.example.myapp.screens.login.LoginScreen(navController)
        }

        composable(Screen.SignUp.route) {
            com.example.myapp.screens.signup.SignUpScreen(navController)
        }

        composable(Screen.Shop.route) {
            com.example.myapp.screens.shop.ShopScreen(navController)
        }

        composable(Screen.Detail.route) { backStackEntry ->
            val id = backStackEntry.arguments?.getString("id")
            com.example.myapp.screens.details.DetailScreen(
                navController = navController,
                productId = id
            )
        }

        composable(Screen.Cart.route) {
            com.example.myapp.screens.cart.CartScreen(navController)
        }
        composable(Screen.Confirmation.route) {
            com.example.myapp.screens.confirmation.ConfirmationScreen(navController)
        }

        composable(Screen.Error.route) {
            com.example.myapp.screens.error.ErrorScreen(navController)
        }
    }
}

