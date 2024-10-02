package com.ams.ej01catalogo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ams.ej01catalogo.ui.theme.Ej01CatalogoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Ej01CatalogoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    //MyBox(modifier = Modifier.padding(innerPadding)) //Le pasamoss el modificador del padre
                    MyComplexLayaout(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Ej01CatalogoTheme {
        MyComplexLayaout()
    }
}

@Composable
fun MyBox(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color.Yellow),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = modifier
                .width(250.dp)
                .height(250.dp)
                .background(Color.Cyan),
            contentAlignment = Alignment.Center
        ) {
            Text("Esto es un ejemplo")
        }
    }
}

@Composable
fun MyComplexLayaout(modifier: Modifier = Modifier) {
    Column(modifier.fillMaxSize()) {
        Box(
            modifier
                .fillMaxWidth()
                .background(Color.Cyan)
                .weight(1f)
        )
        {
            Text("Ejemplo 1")
        }
        MySpacer(80)

        Row(
            modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            Box(
                modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .weight(1f)
                    .background(
                        Color.Red
                    ),
                contentAlignment = Alignment.Center

            ) {
                Text("Ejempl 2")
            }
            Box(
                modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .weight(1f)
                    .background(
                        Color.Green
                    ),
                contentAlignment = Alignment.Center

            ) {
                Text("Ejempl 3")
            }

        }
        MySpacer(80)
        Box(
            modifier
                .fillMaxWidth()
                .background(Color.Blue)
                .weight(1f),
            contentAlignment = Alignment.BottomCenter
        )
        {
            Text("Ejemplo 4")
        }
    }
}

@Composable
fun MySpacer(size: Int) {
    Spacer(modifier = Modifier.height(size.dp))
}
