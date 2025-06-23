package com.pjff.holamundo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Content()
        }
    }
}

/*
Vid 33 Modificadores
De posicionamiento = width, height
de funcionalidad = click, scroll
de apariencia = background, padding, border
de escucha = onKeyEvent
* */

//Vid 30,paso 13
val items = listOf(
    Color.Red,
    Color.Yellow,
    Color.Black,
    Color.Cyan,
    Color.DarkGray,
    Color.Magenta,
    Color.Green
)
//Paso 19
val nombre = "Me Gusta"

//Vid 32 ,nos sirve para ver como va en el simulador
@Preview(showBackground = true)
@Composable
fun Content() {
    //Paso 23, remember para guardar el estado de una variable debe estar dentro de una Composable.
    var likes by remember { mutableStateOf(0) }
    //Paso 4,agregamos una columna
    Column(
        //Paso 8, ponemosel modifier para separlo de las orillas
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
            //Paso 10,padding para los bordes del telefono
            .padding(horizontal = 5.dp)
    ) {
        //Paso 5
        Texto(texto = "Bienvenido")
        //Paso 7 ,llamamos a Space
        Space()
        Texto(texto = "Jetpack")
        Space()
        Texto(texto = "Compose")
        Space()
        //Paso 15, es como un scroll
        LazyRow(
            //Paso 12
            modifier = Modifier
                //Paso 9
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            //Paso 16
            items(items){ item ->
                //Paso 17
                Circulo(color = item)
                Spacer(modifier = Modifier.width(10.dp))
            }
        }
        //Paso 20
        Space()
        Row(
            //Paso 21
            modifier = Modifier
            .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            //Paso 22
            Button(onClick = {
                likes++
            }) {
                Text(text = nombre)
            }
            Spacer(modifier = Modifier.width(10.dp))
            Resultado(likes = likes)
        }
    }

}

//Paso 3
@Composable
fun Texto(texto: String) {
    Text(
        //Vud 33 Paso 1
        text = texto,
        color = Color.Red,
        fontWeight = FontWeight.Bold,
        fontSize = 40.sp,
        textAlign = TextAlign.Center,
        //paso 2, le ponemos el modifier .
        modifier = Modifier
            .background(Color.Black)
            .padding(horizontal = 30.dp)
            .fillMaxWidth()
            .clickable {
                println("Hola Jetpack")
            }
    )
}

//Paso 6
@Composable
fun Space() {
    Spacer(modifier = Modifier.height(5.dp))
}

//Paso 11
@Composable
fun Circulo(color: Color) {
    Box(
        modifier = Modifier
            .size(70.dp)
            .background(color, CircleShape)
    )

}

//Vid 37,Paso 18
@Composable
fun Resultado(likes: Int){
    //Texto se debe pasar a toString
    Text(text = likes.toString(), fontWeight = FontWeight.Bold, fontSize = 50.sp)
}