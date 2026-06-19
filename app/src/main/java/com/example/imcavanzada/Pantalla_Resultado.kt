package com.example.imcavanzada

import android.R
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun PantallaResultado(
    navController: NavController,
    nombre: String,
    imc: Double
){
    val categoria =
        when{
            imc < 18.5 -> "Peso Bajo"
            imc < 25 -> "Peso Normal"
            imc < 30 -> "Sobrepeso"

            else -> "Obeso"
         }
    val colorCategoria =
        when{
            imc < 18.5 -> Color.Red
            imc < 25 -> Color.Green
            imc < 30 -> Color(0xFFFFFA500)

            else -> Color.Red
        }
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp)
    ) {
        Text(
            text = "Hola $nombre"
        )

        Spacer(
            modifier = Modifier.height(16.dp)
        )
        Text(
            text = "Tu resultado de IMC es: "
        )
        Spacer(
            modifier = Modifier.height(16.dp)
        )
        Text(
            text = String.format("%.1f", imc)
        )
        Spacer(
            modifier = Modifier.height(16.dp)
        )
        Text(
            text = categoria,
            color = colorCategoria
        )
        Spacer(
            modifier = Modifier.height(16.dp)
        )
        Button(
            onClick = {
                navController.popBackStack()

            }
        ) {
            Text("Volver")
        }
    }
}