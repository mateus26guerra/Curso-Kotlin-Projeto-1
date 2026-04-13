package com.example.controlefinanceirocompose

sealed class Screen(val rota: String) {

    object Login : Screen("login")
    object Home : Screen("home")
    object Pix : Screen("pix")
    object Extrato : Screen("extrato")
    object Sonhos : Screen("sonhos")

}