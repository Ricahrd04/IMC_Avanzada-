package com.example.imcavanzada

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun Pantalla_Inicio(
    navController: NavController
){
    var nombre by remember {
        mutableStateOf("")
    }
    var peso by remember {
        mutableStateOf("")
    }
    var altura by remember{
        mutableStateOf("")
    }
    var mostrarError by remember{
        mutableStateOf (false)
    }
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp)
    ){
        Text(
            text = "Calculadora IMC"
        )
        Spacer(
            modifier =Modifier.height(16.dp)
        )
        OutlinedTextField(
            value = nombre,
            onValueChange ={
                nombre = it
            },
            label = {
                Text ("Nombre")
            }
        )
        Spacer(
            modifier = Modifier.height(8.dp)
        )
        OutlinedTextField(
            value= peso,
            onValueChange = {
                peso = it
            },
            label = {
                Text ("Peso en kg")
            }
        )
        Spacer(
            modifier = Modifier.height(8.dp)
        )
        OutlinedTextField(
            value = altura,
            onValueChange = {
                altura = it
            },
            label = {
                Text("Altura en metros")
            }
        )
        Spacer(
            modifier = Modifier.height(16.dp)
        )
        Button(
            onClick = {
                val pesoNumero = peso.toDoubleOrNull()

                val alturaNumero = altura.toDoubleOrNull()

                if(
                    pesoNumero==null ||
                    alturaNumero==null ||
                    pesoNumero <= 0 ||
                    alturaNumero <= 0
                ) {
                    mostrarError = true
                } else {
                    mostrarError = false
                    val imc = pesoNumero/(alturaNumero* alturaNumero)

                    navController.navigate("resultado/$nombre/$imc"
                    )
                }
            }
        ){
            Text("Calcular IMC")
        }
        if (mostrarError) {
            Spacer(
                modifier = Modifier.height(8.dp)
            )
            Text(
                text = "Por favor, debe ingresar valores válidos",
                color = Color.Red
            )
        }
    }

}