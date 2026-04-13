package com.example.controlefinanceirocompose.telas

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TelaLogin(onLogin: () -> Unit) {

    var nome by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.Center
    ) {

        Text("Login", fontSize = 28.sp)

        Spacer(Modifier.height(20.dp))

        OutlinedTextField(
            value = nome,
            onValueChange = { nome = it },
            label = { Text("Seu nome") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(Modifier.height(20.dp))

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = { onLogin() }
        ) {
            Text("Entrar")
        }
    }
}