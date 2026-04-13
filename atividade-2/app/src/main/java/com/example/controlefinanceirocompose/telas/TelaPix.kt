package com.example.controlefinanceirocompose.telas

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.controlefinanceirocompose.Banco
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TelaPix(navController: NavController) {

    var valor by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {

        Text("PIX 💸", fontSize = 28.sp)

        Spacer(Modifier.height(20.dp))

        OutlinedTextField(
            value = valor,
            onValueChange = { valor = it },
            label = { Text("Valor") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(Modifier.height(20.dp))

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                Banco.adicionar(valor.toDoubleOrNull() ?: 0.0)
                navController.popBackStack()
            }
        ) {
            Text("Adicionar dinheiro")
        }

        Spacer(Modifier.height(10.dp))

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                Banco.remover(valor.toDoubleOrNull() ?: 0.0)
                navController.popBackStack()
            }
        ) {
            Text("Remover dinheiro")
        }
    }


    TopAppBar(
        title = { Text("Título") },
        navigationIcon = {
            IconButton(onClick = {
                navController.popBackStack()
            }) {
                Icon(Icons.Default.ArrowBack, null)
            }
        }
    )
}