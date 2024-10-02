package com.ams.ej02_constraintlayaout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.FocusRequester.Companion.createRefs
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
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
                    MyConstraintChain(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun MyConstraintLayoutGuide(modifier: Modifier = Modifier) {
    ConstraintLayout(modifier = modifier.fillMaxSize()) {

        val boxRed = createRef()
        val topGui = createGuidelineFromTop(0.1f)
        val startGui = createGuidelineFromStart(0.25f)

        Box(
            modifier
                .size(125.dp)
                .background(Color.Red)
                .constrainAs(boxRed) {
                    top.linkTo(topGui)
                    start.linkTo(startGui)

                })
    }
}

@Composable
fun MyConstraintChain(modifier: Modifier = Modifier) {
    ConstraintLayout(
        modifier = modifier
            .fillMaxSize()
            .padding(20.dp)
            .border(
                1.dp, Color.Green,
                RectangleShape
            )
    ) {
        val (boxRed, boxBlue, boxYellow) = createRefs()
        Box(
            modifier
                .size(75.dp)
                .background(Color.Red)
                .constrainAs(boxRed) {
                    start.linkTo(parent.start)
                    end.linkTo(boxBlue.start)
                })

        Box(
            modifier
                .size(75.dp)
                .background(Color.Blue)
                .constrainAs(boxBlue) {
                    start.linkTo(boxRed.end)
                    end.linkTo(boxYellow.start)
                })

        Box(
            modifier
                .size(75.dp)
                .background(Color.Yellow)
                .constrainAs(boxYellow) {
                    start.linkTo(boxBlue.end)
                    end.linkTo(parent.end)
                })
        createHorizontalChain(boxRed,boxBlue,boxYellow, chainStyle = ChainStyle.SpreadInside)

    }
}

@Composable
fun MyConstraintBarrier(modifier: Modifier = Modifier) {
    ConstraintLayout(modifier.fillMaxSize()) {
        val (boxRed, boxBlue, boxYellow) = createRefs()
        val barrier = createEndBarrier(boxRed, boxBlue)

        Box(
            modifier
                .size(125.dp)
                .background(Color.Red)
                .constrainAs(boxRed) {
                    start.linkTo(parent.start, margin = 16.dp)
                })

        Box(
            modifier
                .size(225.dp)
                .background(Color.Blue)
                .constrainAs(boxBlue) {
                    start.linkTo(parent.start, margin = 32.dp)
                })

        Box(
            modifier
                .size(50.dp)
                .background(Color.Yellow)
                .constrainAs(boxYellow) {
                    start.linkTo(barrier)
                })

    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    Ej02ConstraintLayaoutTheme {
        MyConstraintChain()
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

        Box(
            modifier
                .size(125.dp)
                .background(Color.Green)
                .constrainAs(boxGreen) {
                    start.linkTo(boxRed.end)
                    top.linkTo(boxRed.bottom)
                })
    }


}