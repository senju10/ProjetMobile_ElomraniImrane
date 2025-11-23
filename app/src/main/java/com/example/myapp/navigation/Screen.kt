package com.example.myapp.navigation

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