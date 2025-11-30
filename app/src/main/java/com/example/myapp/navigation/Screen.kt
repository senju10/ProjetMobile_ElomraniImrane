package com.example.myapp.navigation

import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen(val route: String) {
    object Welcome : Screen("welcome")

    object Login : Screen("login")

    object SignUp : Screen("signup")

    object Shop : Screen("shop")

    object Detail : Screen("detail/{id}") {
        fun createRoute(id: String) = "detail/$id"
    }

    object Cart : Screen("cart")

    object Confirmation : Screen("confirmation")

    object Error : Screen("error")
}

