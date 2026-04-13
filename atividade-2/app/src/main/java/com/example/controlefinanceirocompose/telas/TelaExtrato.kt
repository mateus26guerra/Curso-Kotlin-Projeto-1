package com.example.controlefinanceirocompose.telas

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.sp
import com.example.controlefinanceirocompose.Banco
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.navigation.NavController


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TelaExtrato(navController: NavController) {

    LazyColumn {

        item {
            Text("Extrato 📄", fontSize = 28.sp)
        }

        items(Banco.extrato) { movimento ->

            Text(
                movimento,
                fontSize = 20.sp
            )
        }
    }

    TopAppBar(
        title = { Text("Título") },
        navigationIcon = {
            IconButton (onClick = {
                navController.popBackStack()
            }) {
                Icon(Icons.Default.ArrowBack, null)
            }
        }
    )
}