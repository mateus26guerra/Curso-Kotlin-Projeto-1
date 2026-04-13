package com.example.controlefinanceirocompose.telas

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.controlefinanceirocompose.Banco
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TelaSonhos(navController: NavController) {

    var novoSonho by remember { mutableStateOf("") }

    Scaffold(

        topBar = {
            TopAppBar(
                title = { Text("Sonhos ⭐") },
                navigationIcon = {
                    IconButton(onClick = {
                        navController.popBackStack()
                    }) {
                        Icon(Icons.Default.ArrowBack, null)
                    }
                }
            )
        },

        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    if (novoSonho.isNotBlank()) {
                        Banco.criarSonho(novoSonho)
                        novoSonho = ""
                    }
                }
            ) {
                Icon(Icons.Default.Add, null)
            }
        }

    ) { padding ->

        Column(
            Modifier
                .padding(padding)
                .padding(20.dp)
        ) {

            OutlinedTextField(
                value = novoSonho,
                onValueChange = { novoSonho = it },
                label = { Text("Novo sonho") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(Modifier.height(20.dp))

            LazyColumn {

                items(Banco.sonhos) { sonho ->

                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp)
                    ) {

                        Column(Modifier.padding(16.dp)) {

                            Text(sonho.nome, fontSize = 20.sp)

                            Text("Guardado: R$ ${sonho.valor}")

                            Spacer(Modifier.height(10.dp))

                            Button(
                                onClick = {
                                    Banco.adicionarAoSonho(sonho, 10.0)
                                }
                            ) {
                                Text("+ R$10")
                            }
                        }
                    }
                }
            }
        }
    }
}