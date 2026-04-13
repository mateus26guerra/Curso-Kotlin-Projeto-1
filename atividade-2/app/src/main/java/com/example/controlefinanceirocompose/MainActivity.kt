package com.example.controlefinanceirocompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.controlefinanceirocompose.telas.*
import com.example.controlefinanceirocompose.ui.theme.ControleFinanceiroComposeTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {

            ControleFinanceiroComposeTheme {

                val navController = rememberNavController()

                NavHost(
                    navController = navController,
                    startDestination = Screen.Login.rota
                ) {

                    composable(Screen.Login.rota) {
                        TelaLogin {
                            navController.navigate(Screen.Home.rota)
                        }
                    }

                    composable(Screen.Home.rota) {
                        TelaHome(navController)
                    }

                    composable(Screen.Pix.rota) {
                        TelaPix(navController)
                    }

                    composable(Screen.Extrato.rota) {
                        TelaExtrato(navController)
                    }

                    composable(Screen.Sonhos.rota) {
                        TelaSonhos(navController)
                    }
                }
            }
        }
    }
}