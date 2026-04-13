package com.example.controlefinanceirocompose.telas

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.controlefinanceirocompose.Banco

@Composable
fun TelaHome(navController: NavController) {

    Scaffold(

        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navController.navigate("pix")
                }
            ) {
                Text("+", fontSize = 24.sp)
            }
        }

    ) { padding ->

        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .padding(20.dp)
        ) {

            Text("Olá 👋", fontSize = 26.sp)

            Spacer(Modifier.height(20.dp))

            Card(
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(Modifier.padding(20.dp)) {

                    Text("Saldo da conta")

                    Text(
                        "R$ ${Banco.saldo.value}",
                        fontSize = 28.sp
                    )
                }
            }

            Spacer(Modifier.height(30.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {

                Button(
                    onClick = {
                        navController.navigate("extrato")
                    }
                ) {
                    Text("Extrato")
                }

                Button(
                    onClick = {
                        navController.navigate("sonhos")
                    }
                ) {
                    Text("Sonhos")
                }
            }
        }
    }


}