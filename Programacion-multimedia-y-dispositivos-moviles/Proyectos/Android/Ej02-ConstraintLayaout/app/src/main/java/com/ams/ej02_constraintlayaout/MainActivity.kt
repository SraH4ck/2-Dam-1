package com.ams.ej02_constraintlayaout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester.Companion.createRefs
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintLayout
import com.ams.ej02_constraintlayaout.ui.theme.Ej02ConstraintLayaoutTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Ej02ConstraintLayaoutTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MyConstrainLayaout(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    Ej02ConstraintLayaoutTheme {
        MyConstrainLayaout()
    }
}

@Composable
fun MyConstrainLayaout(modifier: Modifier = Modifier) {


    ConstraintLayout(modifier = modifier.fillMaxSize()) {

        val (boxRed, boxBlue, boxYellow, boxMagenta, boxGreen) = createRefs()

        Box(
            modifier
                .size(125.dp)
                .background(Color.Red)
                .constrainAs(boxRed) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom)
                })


        Box(
            modifier
                .size(125.dp)
                .background(Color.Yellow)
                .constrainAs(boxYellow) {
                    end.linkTo(boxRed.start)
                    bottom.linkTo(boxRed.top)
                })


        Box(
            modifier
                .size(125.dp)
                .background(Color.Magenta)
                .constrainAs(boxMagenta) {
                    start.linkTo(boxRed.end)
                    bottom.linkTo(boxRed.top)
                })


        Box(
            modifier
                .size(125.dp)
                .background(Color.Blue)
                .constrainAs(boxBlue) {
                    end.linkTo(boxRed.start)
                    top.linkTo(boxRed.bottom)
                })

        Box(modifier
            .size(125.dp)
            .background(Color.Green)
            .constrainAs(boxGreen) {
                start.linkTo(boxRed.end)
                top.linkTo(boxRed.bottom)
            })
    }


}